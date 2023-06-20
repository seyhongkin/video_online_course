package com.hong.dev.elearning.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e){
		ErrorHandler errorHandler = new ErrorHandler(e.getStatus(), e.getMessage());
		return ResponseEntity
				.status(e.getStatus())
				.body(errorHandler);
	}
}
