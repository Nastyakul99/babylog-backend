package kulav.babylog.aspects.authentication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import kulav.babylog.exceptions.AuthenticationException;
import kulav.babylog.models.sign.request.SignedRequest;
import kulav.babylog.services.sign.SignGenImpl;

@Component
@Aspect
public class AuthenticationAspect {
	
	
	@Value("${kulav.appid}")
	private String appId;
	
	@Autowired
	private SignGenImpl signGenImpl;
	
	@Autowired
	private MessageSource messageSource;

    @Before("@annotation(kulav.babylog.aspects.authentication.Signed)")
    public void check(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs(); // Получаем массив аргументов
        List<Object> requests = Stream.of(args)
        .filter(this::isSignedRequest)
        .collect(Collectors.toList());
        
        if (requests.isEmpty()) throw new AuthenticationException(messageSource, "error.authentication.signedrequest.missing");
        if (requests.size() > 1) throw new AuthenticationException(messageSource, "error.authentication.signedrequest.not.alone");      
       
        SignedRequest request = (SignedRequest) (requests.get(0));
        
        String sign = signGenImpl.generate(request.createData(appId));
        
        if (!sign.equals(request.getSign())) throw new AuthenticationException(messageSource, "error.authentication.signature.not.valid");

    }
    
    private boolean isSignedRequest(Object arg) {
    	return (arg instanceof SignedRequest);
    }
}
