package com.biskot.app.exptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<Object> handelApiRespence(ApiException e){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ApiResponce apiException = new  ApiResponce(e.getMessage(),HttpStatus.BAD_REQUEST);
		return new  ResponseEntity<>(apiException,httpStatus);

	}
}
