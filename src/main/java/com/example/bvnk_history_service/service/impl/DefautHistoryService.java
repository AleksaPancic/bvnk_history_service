package com.example.bvnk_history_service.service.impl;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import com.example.bvnk_history_service.populator.Populator;
import com.example.bvnk_history_service.repository.HistoryDAO;
import com.example.bvnk_history_service.service.HistoryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DefautHistoryService implements HistoryService {

	private final HistoryDAO historyDAO;
	private final Populator<HistoryDto, History> populator;

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(DefautHistoryService.class);

	@Autowired
	public DefautHistoryService(final HistoryDAO historyDAO, Populator<HistoryDto, History> populator) {
		this.historyDAO = historyDAO;
		this.populator = populator;
	}

	@Transactional(readOnly = true)
	@Override
	public History getHistoryForClient(final Long clientId) {
		final History history = historyDAO.findByClientId(clientId).orElse(null);
		if (history == null) {
			throw new IllegalArgumentException(String.format("History for client with id %s not found", clientId));
		}
		LOG.info("History for client with id {} found", clientId);
		return history;
	}

	@Transactional
	@Override
	public History createHistoryForClient(final HistoryDto historyDto) {
		History history = historyDAO.findByClientId(historyDto.getClientId()).orElse(null);
		if (history != null) {
			throw new IllegalArgumentException(
					String.format(String.format("History for client with id %s already exists", historyDto.getClientId())));
		}
		history = new History();
		populator.populate(historyDto, history);
		LOG.info("History for client with id {} created", historyDto.getClientId());
		return historyDAO.saveAndFlush(history);
	}

	@Transactional
	@Override
	public History updateHistory(final HistoryDto historyDto) {
		final History history = historyDAO.findByClientId(historyDto.getClientId()).orElse(null);
		if (history == null) {
			throw new IllegalArgumentException(
					String.format("History for client with id %s not found", historyDto.getClientId()));
		}
		populator.populate(historyDto, history);
		LOG.info("History for client with id {} updated", historyDto.getClientId());
		return historyDAO.saveAndFlush(history);
	}

	@Transactional
	@Override
	public History deleteHistoryForClient(Long clientId) {
		History history = historyDAO.findByClientId(clientId).orElse(null);
		if (history == null) {
			throw new IllegalArgumentException(String.format(String.format("History for client with id %s not found",
																		   clientId)));
		}
		historyDAO.delete(history);
		LOG.info("History for client with id {} deleted", clientId);
		return history;
	}

}
