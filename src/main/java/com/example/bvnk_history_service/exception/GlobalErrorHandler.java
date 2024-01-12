package com.example.bvnk_history_service.exception;

import com.example.bvnk_history_service.entity.History;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<History> handleIllegalArgumentException(IllegalArgumentException e) {
		return null;
	}

}
