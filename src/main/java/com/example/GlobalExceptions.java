package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions 
{

	//When User enter id whcih does not has any user corresponding to it then this exception is called
	@ExceptionHandler(NoUserFoundException.class)
		public ResponseEntity<String> NoUser(NoUserFoundException exception) 
		{	  
			  return new ResponseEntity<String> (exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	
	//When User enter does not enter name during POST API then this exception is called
	@ExceptionHandler(NoNameException.class)
	public ResponseEntity<String> NoName(NoNameException exception)
	{	  
		  return new ResponseEntity<String> (exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	//Global Exception
	@ExceptionHandler(Exception.class)
		public HttpStatus globalException()
		{
			return (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
