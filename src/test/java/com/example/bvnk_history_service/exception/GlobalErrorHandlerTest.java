package com.example.bvnk_history_service.exception;

import com.example.bvnk_history_service.exception.response.ResponseError;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class GlobalErrorHandlerTest {

	@Autowired
	private GlobalErrorHandler globalErrorHandler;

	@Test
	public void shouldHandleIllegalArgumentException() {
		ResponseEntity<ResponseError> response = globalErrorHandler.handleIllegalArgumentException(
				new IllegalArgumentException("test"));

		assertThat(globalErrorHandler.handleIllegalArgumentException(new IllegalArgumentException("test"))
									 .getStatusCode()).isEqualTo(
				HttpStatus.BAD_REQUEST);
	}
}
