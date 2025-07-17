package com.example.sms.exception;

public class NoStudentObjectFoundException extends RuntimeException {

	private String message;

	public NoStudentObjectFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
