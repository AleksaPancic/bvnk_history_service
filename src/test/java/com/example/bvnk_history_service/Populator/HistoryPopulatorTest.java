package com.example.bvnk_history_service.Populator;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class HistoryPopulatorTest {

	@Mock
	private HistoryDto historyDto;

	@Test
	public void shouldPopulateHistory() {

		History history = new History();
		history.setClientId(historyDto.getClientId());
		history.setHistoryContent(historyDto.getHistoryContent());
		history.setHistoryName(historyDto.getHistoryName());
		history.setHistoryDescription(historyDto.getHistoryDescription());

		assertThat(history.getClientId()).isEqualTo(historyDto.getClientId());
		assertThat(history.getHistoryContent()).isEqualTo(historyDto.getHistoryContent());
		assertThat(history.getHistoryName()).isEqualTo(historyDto.getHistoryName());
		assertThat(history.getHistoryDescription()).isEqualTo(historyDto.getHistoryDescription());

	}

}
