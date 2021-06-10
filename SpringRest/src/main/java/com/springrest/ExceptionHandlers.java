package com.springrest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springrest.dtos.ErrorDetails;
import com.springrest.exceptions.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handlEntityNotFoundException(EntityNotFoundException exception, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}