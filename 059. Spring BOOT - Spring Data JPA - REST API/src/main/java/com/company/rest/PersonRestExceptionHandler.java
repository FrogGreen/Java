package com.company.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exception) {

		PersonErrorResponse error = new PersonErrorResponse();
		error.setId(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(Exception exception) {

		PersonErrorResponse error = new PersonErrorResponse();
		error.setId(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}