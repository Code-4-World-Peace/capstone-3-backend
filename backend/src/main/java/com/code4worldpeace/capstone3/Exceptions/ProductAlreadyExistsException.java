package com.code4worldpeace.capstone3.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.*;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.CONFLICT, reason="Product Already Exists")
public class ProductAlreadyExistsException extends RuntimeException {

	public ProductAlreadyExistsException(String msg) {
		super(msg);
	}
}