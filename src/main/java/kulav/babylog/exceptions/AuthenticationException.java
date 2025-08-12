package kulav.babylog.exceptions;

import java.util.Locale;
import org.springframework.context.MessageSource;

public class AuthenticationException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 1L;

	public AuthenticationException(MessageSource messageSource, String messageName) {
		super(messageSource.getMessage(messageName, new Object[]{}, Locale.getDefault()));
	}
}
