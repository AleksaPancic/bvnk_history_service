package com.example.bvnk_history_service.service;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import com.example.bvnk_history_service.populator.Populator;
import com.example.bvnk_history_service.repository.HistoryDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class HistoryServiceTest {

	private final HistoryDAO historyDAO;
	private final Populator<HistoryDto, History> populator;

	private final HistoryService testInstance;

	public static final Long CLIENT_ID = 13L;
	public static final Long CLIENT_ID_UPDATE = 14L;

	@Autowired
	public HistoryServiceTest(final HistoryDAO historyDAO, Populator<HistoryDto, History> populator,
							  HistoryService testInstance) {
		this.historyDAO = historyDAO;
		this.populator = populator;
		this.testInstance = testInstance;
	}

	@BeforeEach
	public void setUp() {
		History history = new History();
		history.setClientId(CLIENT_ID);
		historyDAO.saveAndFlush(history);
	}

	@Test
	public void getHistoryForClient() {
		final History result = testInstance.getHistoryForClient(CLIENT_ID);

		assertThat(result).isNotNull();
		assertThat(result).isInstanceOf(History.class);
	}

	@Test
	public void getHistoryForClientShouldThrowExceptionIfHistoryNotFound() {
		assertThrows(IllegalArgumentException.class, () -> testInstance.getHistoryForClient(CLIENT_ID_UPDATE),
					 "History for client with id " + CLIENT_ID + " not found");
	}

	@Test
	public void createHistoryForClient() {
		HistoryDto historyDto = new HistoryDto();
		historyDto.setClientId(CLIENT_ID_UPDATE);

		final History result = testInstance.createHistoryForClient(historyDto);

		assertThat(result).isNotNull();
		assertThat(result).isInstanceOf(History.class);
	}

	@Test
	public void createHistoryForClientShouldThrowExceptionIfHistoryAlreadyExists() {
		HistoryDto historyDto = new HistoryDto();
		historyDto.setClientId(CLIENT_ID);


		assertThrows(IllegalArgumentException.class, () -> testInstance.createHistoryForClient(historyDto),
					 String.format("History for client with id %s already exists", historyDto.getClientId()));
	}

	@Test
	public void updateHistoryForClient() {
		HistoryDto historyDto = new HistoryDto();
		historyDto.setClientId(CLIENT_ID);

		final History result = testInstance.updateHistory(historyDto);

		assertThat(result).isNotNull();
	}

	@Test
	public void updateHistoryForClientShouldThrowExceptionIfHistoryNotFound() {
		HistoryDto historyDto = new HistoryDto();
		historyDto.setClientId(CLIENT_ID_UPDATE);

		assertThrows(IllegalArgumentException.class, () -> testInstance.updateHistory(historyDto),
					 String.format("History for client with id %s not found", historyDto.getClientId()));
	}

	@Test
	public void deleteHistoryForClient() {

		final History result = testInstance.deleteHistoryForClient(CLIENT_ID);

		assertThat(result).isNotNull();
	}

	@Test
	public void deleteHistoryForClientShouldThrowExceptionIfHistoryNotFound() {

		assertThrows(IllegalArgumentException.class, () -> testInstance.deleteHistoryForClient(CLIENT_ID_UPDATE),
					 String.format("History for client with id %s not found", CLIENT_ID_UPDATE));
	}

}
