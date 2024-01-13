package com.example.bvnk_history_service.controller;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import com.example.bvnk_history_service.service.HistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class HistoryControllerTest {

	@InjectMocks
	private HistoryController historyController;

	@Mock
	private HistoryService historyService;

	@Mock
	private History history;

	@Mock
	private HistoryDto historyDto;

	private Map<String, String> headers;

	public static final Long CLIENT_ID = 13L;


	@BeforeEach
	public void setUp() {
		headers = new HashMap<>();
	}

	@Test
	public void getHistoryForClientSuccess() {
		when(historyService.getHistoryForClient(CLIENT_ID)).thenReturn(history);
		ResponseEntity<History> result = historyController.getHistoryForClient(headers, CLIENT_ID);
		assertThat(result.getBody()).isEqualTo(history);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		verify(historyService).getHistoryForClient(CLIENT_ID);
	}

	@Test
	public void getHistoryForClientFailure_ShouldThrowIllegalArgumentException() {
		when(historyService.getHistoryForClient(CLIENT_ID)).thenThrow(new IllegalArgumentException());

		assertThrows(IllegalArgumentException.class, () -> historyController.getHistoryForClient(headers, CLIENT_ID),
					 "History for client with id " + CLIENT_ID + " not found");

	}

	@Test
	public void getHistoryForClientFailure_ShouldThrowNullPointerException() {

		assertThrows(NullPointerException.class, () -> historyController.getHistoryForClient(headers, null),
					 "History for client with id " + CLIENT_ID + " not found");
	}

	@Test
	public void updateHistoryForClientSuccess() {
		when(historyService.updateHistory(historyDto)).thenReturn(history);

		ResponseEntity<History> result = historyController.updateHistoryForClient(headers, historyDto);

		assertThat(result.getBody()).isEqualTo(history);
	}

	@Test
	public void updateHistoryForClientFailure_ShouldThrowIllegalArgumentException() {

		when(historyService.updateHistory(historyDto)).thenThrow(new IllegalArgumentException());

		assertThrows(IllegalArgumentException.class, () -> historyController.updateHistoryForClient(headers, historyDto),
					 "History for client with id " + CLIENT_ID + " not found");
	}

	@Test
	public void updateHistoryForClientFailure_ShouldThrowNullPointerException() {

		assertThrows(NullPointerException.class, () -> historyController.updateHistoryForClient(headers, null),
					 "History for client with id " + CLIENT_ID + " not found");
	}

	@Test
	public void createHistoryForClientSuccess() {

		when(historyService.createHistoryForClient(historyDto)).thenReturn(history);

		ResponseEntity<History> result = historyController.createHistoryForClient(headers, historyDto);

		assertThat(result.getBody()).isEqualTo(history);
	}

	@Test
	public void createHistoryForClientFailure_ShouldThrowIllegalArgumentException() {

		when(historyService.createHistoryForClient(historyDto)).thenThrow(new IllegalArgumentException());

		assertThrows(IllegalArgumentException.class, () -> historyController.createHistoryForClient(headers, historyDto),
					 "History for client with id " + CLIENT_ID + " not found");
	}

	@Test
	public void createHistoryForClientFailure_ShouldThrowNullPointerException() {
		assertThrows(NullPointerException.class, () -> historyController.createHistoryForClient(headers, null), "test");
	}

	@Test
	public void deleteHistoryForClientSuccess() {

		when(historyService.deleteHistoryForClient(CLIENT_ID)).thenReturn(history);

		ResponseEntity<History> result = historyController.deleteHistoryForClient(headers, CLIENT_ID);

		assertThat(result.getBody()).isEqualTo(history);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void deleteHistoryForClientFailure_ShouldThrowIllegalArgumentException() {

		when(historyService.deleteHistoryForClient(CLIENT_ID)).thenThrow(new IllegalArgumentException());

		assertThrows(IllegalArgumentException.class, () -> historyController.deleteHistoryForClient(headers, CLIENT_ID),
					 String.format("History for client with id %s not found", CLIENT_ID));
	}

	@Test
	public void deleteHistoryForClientFailure_ShouldThrowNullPointerException() {

		assertThrows(NullPointerException.class, () -> historyController.deleteHistoryForClient(headers, null),
					 "History for client with id " + CLIENT_ID + " not found");
	}

}
