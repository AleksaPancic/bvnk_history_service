package com.example.bvnk_history_service.exception;

import com.example.bvnk_history_service.exception.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ResponseError> handleIllegalArgumentException(final IllegalArgumentException e) {
		ResponseError responseError = new ResponseError();
		responseError.setMessage(e.getMessage());
		responseError.setStatus(HttpStatus.BAD_REQUEST);
		responseError.setCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.badRequest().body(responseError);
	}

}
