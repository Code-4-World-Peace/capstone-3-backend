package com.code4worldpeace.capstone3.Exceptions.Model.Handler;

import java.sql.Timestamp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.code4worldpeace.capstone3.Exceptions.Model.Response.ErrorResponse;
import com.code4worldpeace.capstone3.Exceptions.*;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    // ProductAlreadyExistsException - 409 Conflict
 	@ExceptionHandler(value = ProductAlreadyExistsException.class)
     protected ResponseEntity<Object> handleUserAlreadyExistsException(ProductAlreadyExistsException ex, WebRequest request) {
     	
     	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
     	
     	ErrorResponse errorResponse = new ErrorResponse(
     			timestamp, 
     			HttpStatus.CONFLICT.value(), 
     			HttpStatus.CONFLICT.getReasonPhrase(), 
     			ex.getMessage(), 
     			request.getDescription(false)
     	);
     	
     	return handleExceptionInternal(ex, errorResponse.getResponse(), new HttpHeaders(), HttpStatus.CONFLICT, request);
     }
}

