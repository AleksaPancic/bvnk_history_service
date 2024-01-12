package com.example.bvnk_history_service.service.impl;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import com.example.bvnk_history_service.populator.Populator;
import com.example.bvnk_history_service.repository.HistoryDAO;
import com.example.bvnk_history_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DefautHistoryService implements HistoryService {

	private final HistoryDAO historyDAO;
	private final Populator<HistoryDto, History> populator;

	@Autowired
	public DefautHistoryService(final HistoryDAO historyDAO, Populator<HistoryDto, History> populator) {
		this.historyDAO = historyDAO;
		this.populator = populator;
	}

	@Override
	public History getHistoryForClient(final Long clientId) {
		final History history = historyDAO.findByClientId(clientId).orElse(null);
		if (history == null) {
			throw new IllegalArgumentException(String.format("History for client with id %s not found", clientId));
		}
		return history;
	}

	@Transactional
	@Override
	public History createHistoryForClient(final HistoryDto historyDto) {
		final History history = new History();
		populator.populate(historyDto, history);
		return historyDAO.saveAndFlush(history);
	}

}
