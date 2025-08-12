package kulav.babylog.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;
import kulav.babylog.models.dto.ErrorResponse;
import kulav.babylog.exceptions.AuthenticationException;

@RestControllerAdvice
public class ErrorController extends DefaultResponseErrorHandler {
	
	public Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ErrorResponse> handleAuthExceptions(Exception e) {
		return handleExceptions(e, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
		return handleExceptions(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<ErrorResponse> handleExceptions(Exception e, HttpStatus status) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		logger.error("", e);
		String stackTrace = stringWriter.toString();
		ErrorResponse response = ErrorResponse.builder().message(e.getMessage()).stackTrace(stackTrace).build();

		return new ResponseEntity<ErrorResponse>(response, status);
	}
}