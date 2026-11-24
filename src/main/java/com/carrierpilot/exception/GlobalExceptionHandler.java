package com.carrierpilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<String> HandleEmailExists(EmailAlreadyExistsException ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
	}
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRunTimeException(RuntimeException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	

}
