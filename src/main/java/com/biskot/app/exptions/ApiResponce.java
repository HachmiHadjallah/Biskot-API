package com.biskot.app.exptions;

import org.springframework.http.HttpStatus;

public class ApiResponce {
	
public final String message;
public final HttpStatus httpStatus;

public ApiResponce(String message, HttpStatus httpStatus) {
	this.message = message;
	this.httpStatus = httpStatus;
}

public String getMessage() {
	return message;
}
public HttpStatus getHttpStatus() {
	return httpStatus;
}


}
