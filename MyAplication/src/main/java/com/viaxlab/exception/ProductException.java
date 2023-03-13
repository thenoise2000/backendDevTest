package com.viaxlab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import feign.FeignException.FeignClientException;

@RestControllerAdvice
public class ProductException {

	@ExceptionHandler({FeignClientException.class})
	public ResponseEntity<Object> handleNotFound(FeignClientException e){
		return new ResponseEntity<Object>("ID Not exist", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler({FeignException.class})
	public ResponseEntity<Object> handleError(FeignException e){
		return new ResponseEntity<Object>("Error exception", HttpStatus.NOT_ACCEPTABLE);
	}
}
