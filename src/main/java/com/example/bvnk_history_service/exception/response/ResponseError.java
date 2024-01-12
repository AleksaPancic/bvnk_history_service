package com.example.bvnk_history_service.exception.response;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class ResponseError {
	private String message;
	private int code;
	private HttpStatus status;
}
