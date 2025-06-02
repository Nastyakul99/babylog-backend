package kulav.babylog.aspects.authentication;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import kulav.babylog.models.request.SignedRequest;
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
        
        if (requests.isEmpty()) throw new IllegalArgumentException(
        		messageSource.getMessage("error.authentication.signedrequest.missing", new Object[]{}, Locale.getDefault()));
        if (requests.size() > 1) throw new IllegalArgumentException(
        		messageSource.getMessage("error.authentication.signedrequest.not.alone", new Object[]{}, Locale.getDefault()));      
       
        SignedRequest request = (SignedRequest) (requests.get(0));
        
        String sign = signGenImpl.generate(request.createData(appId));
        
        if (!sign.equals(request.getSign())) throw new IllegalArgumentException(
        		messageSource.getMessage("error.authentication.signature.not.valid", new Object[]{}, Locale.getDefault()));

    }
    
    private boolean isSignedRequest(Object arg) {
    	return (arg instanceof SignedRequest);
    }
}
