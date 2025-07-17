package com.example.sms.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sms.exception.NoStudentObjectFoundException;
import com.example.sms.exception.StudentNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleStudentNotFoundByIdException(StudentNotFoundByIdException ex){
		
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorcode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(ex.getMessage());
		es.setError("Student object with the requested id is not available in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleNoStudentFounddException(NoStudentObjectFoundException ex){
		
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorcode(HttpStatus.NOT_FOUND.value());
		es.setErrorMessage(ex.getMessage());
		es.setError("No Student objects are available in the Database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	
}
