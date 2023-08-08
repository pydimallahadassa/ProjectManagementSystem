package com.leader.main.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(NullUserFound.class)
	public ResponseEntity<String> nullUserFoundException(NullUserFound nuf) {

		return new ResponseEntity<>(nuf.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(NullEmailFoundException.class)
	public ResponseEntity<String> nullEmailFoundException(NullEmailFoundException nuef) {

		return new ResponseEntity<>(nuef.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(InvalidUserId.class)
	public ResponseEntity<String> invalidUserId(InvalidUserId iuri) {

		return new ResponseEntity<>(iuri.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> cantLoginUser(InvalidCredentialsException invc) {

		return new ResponseEntity<>(invc.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
