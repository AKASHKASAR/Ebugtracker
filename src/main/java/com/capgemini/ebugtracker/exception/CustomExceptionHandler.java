package com.capgemini.ebugtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(UsernamePasswordInvalidException.class)
	public final ResponseEntity<Object> handleUsernamePasswordInvalidException() {
		LOG.error("handleUsernamePasswordInvalidException");
		return new ResponseEntity<Object>("Invalid username and Password", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserLoginException.class)
	public final ResponseEntity<Object> handleInvalidUserLoginExceptionException() {
		LOG.error("handleInvalidUserLoginExceptionException");
		return new ResponseEntity<Object>("Invalid user login", HttpStatus.NOT_FOUND);
	}

	// create more methods to handle other custom exceptions
	
	@ExceptionHandler(IdNotFoundException.class)
	public final ResponseEntity<Object> handleIdNotFoundException() {
		LOG.error("handleIdNotFoundException");
		return new ResponseEntity<Object>("Id Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public final ResponseEntity<Object> handleEmailNotFoundException() {
		LOG.error("handleEmailNotFoundException");
		return new ResponseEntity<Object>("Email Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BugNotFoundException.class)
	public final ResponseEntity<Object> handleBugNotFoundException() {
		LOG.error("Bug Not Found");
		return new ResponseEntity<Object>(buildErrorMessge("BUG_NOT_FOUND",
				"Bug not found"), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException() {
		LOG.error("User Not Found");
		return new ResponseEntity<Object>(buildErrorMessge("USER_NOT_FOUND",
				"User not found"), HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleException() {
//		LOG.error("Unknown Exception occurred");
//		return new ResponseEntity<Object>(buildErrorMessge("INTERNAL_SERVER_ERROR",
//				"Something went wrong, please try after some time"), HttpStatus.INTERNAL_SERVER_ERROR);
//	}

	private ErrorMessge buildErrorMessge(String errorCode, String errorMessage){
		ErrorMessge errorMessge = new ErrorMessge();
		errorMessge.setErrorCode(errorCode);
		errorMessge.setErrorMessage(errorMessage);
		return errorMessge;
	}
}
