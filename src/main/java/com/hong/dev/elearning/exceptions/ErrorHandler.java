package com.hong.dev.elearning.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorHandler {
	private final HttpStatus status;
	private final String message;	
}
