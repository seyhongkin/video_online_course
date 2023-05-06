package com.hong.dev.elearning.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String entityName, Long id) {
		super(HttpStatus.NOT_FOUND, "%s_id=%d is not found.".formatted(entityName, id));
	}

}
