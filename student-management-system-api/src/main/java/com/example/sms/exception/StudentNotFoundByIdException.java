package com.example.sms.exception;

public class StudentNotFoundByIdException extends RuntimeException {
	
	private String message;

	public StudentNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
