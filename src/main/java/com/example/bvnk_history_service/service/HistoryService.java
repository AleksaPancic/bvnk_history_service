package com.example.bvnk_history_service.service;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;


public interface HistoryService {

	/**
	 * Retrieves the history for a specific client.
	 *
	 * @param  clientId  the ID of the client for which to retrieve the history
	 * @return           the history object containing the client's history
	 */
	History getHistoryForClient(Long clientId);

	/**
	 * Creates a new history entry for a client.
	 *
	 * @param  historyDto  the history DTO object containing the necessary data for creating the history entry
	 * @return             the created history object
	 */
	History createHistoryForClient(HistoryDto historyDto);

	/**
	 * Updates the history using the provided HistoryDto.
	 *
	 * @param  historyDto  the HistoryDto object containing the data to update the history
	 * @return             the updated History object
	 */
	History updateHistory(HistoryDto historyDto);

	/**
	 * Deletes the history for a specific client.
	 *
	 * @param  clientId  the ID of the client whose history will be deleted
	 * @return           the deleted history object
	 */
	History deleteHistoryForClient(Long clientId);

}
