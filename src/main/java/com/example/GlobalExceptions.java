package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions 
{

	@ExceptionHandler(NoUserFoundException.class)
		public ResponseEntity<String> NoUser(NoUserFoundException exception)
		{	  
			  return new ResponseEntity<String> (exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler(NoNameException.class)
	public ResponseEntity<String> NoName(NoNameException exception)
	{	  
		  return new ResponseEntity<String> (exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Exception.class)
		public HttpStatus globalException()
		{
			return (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
