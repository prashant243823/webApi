package com.webApi.webApi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.webApi.webApi.Exception.ResourceNotFound;

@RestControllerAdvice
public class WebApiControllerAdvice {

	@ExceptionHandler(value = ResourceNotFound.class)
	public ResponseEntity<?> dataNotFound(ResourceNotFound no) {
		String message = "Not records found "+no.getMessage();
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

}
