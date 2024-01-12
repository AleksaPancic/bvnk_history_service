package com.example.bvnk_history_service.controller;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import com.example.bvnk_history_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/history")
public class HistoryController {

	private final HistoryService historyService;

	@Autowired
	public HistoryController(final HistoryService historyService) {
		this.historyService = historyService;
	}

	@GetMapping("/{client_id}")
	public ResponseEntity<History> getHistoryForClient(@RequestHeader Map<String, String> headers,
													   @PathVariable(name = "client_id") Long clientId) {
		//logic to check headers can be done like Objects.requireNonNull(headers); or if (headers.containsKey("Authorization"))
		Objects.requireNonNull(clientId);

		return ResponseEntity.ok().body(historyService.getHistoryForClient(clientId));
	}

	@PatchMapping("/{client_id}")
	public ResponseEntity<History> updateHistoryForClient(@RequestHeader Map<String, String> headers,
														  @RequestBody HistoryDto historyDto) {
		Objects.requireNonNull(historyDto);
		return ResponseEntity.ok().body(historyService.updateHistory(historyDto));
	}

	@PostMapping("/create")
	public ResponseEntity<History> createHistoryForClient(@RequestHeader Map<String, String> headers,
														  @RequestBody HistoryDto historyDto) {
		Objects.requireNonNull(historyDto);

		return ResponseEntity.ok().body(historyService.createHistoryForClient(historyDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<History> deleteHistoryForClient(@RequestHeader Map<String, String> headers,
														  @RequestParam Long clientId) {
		Objects.requireNonNull(clientId);
		return ResponseEntity.ok().body(historyService.deleteHistoryForClient(clientId));
	}

}
