package com.hong.dev.elearning.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@RequiredArgsConstructor
public class ApiException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;
	private final String message;
}
