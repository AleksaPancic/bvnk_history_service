package com.example.bvnk_history_service.repository;

import com.example.bvnk_history_service.entity.History;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class HistoryDAOTest {

	@Autowired
	private HistoryDAO testingInstance;

	@Test
	public void fetchHistoryForClient() {
		Long CLIENT_ID = 13L;
		History history = new History();
		history.setClientId(CLIENT_ID);

		testingInstance.saveAndFlush(history);

		Optional<History> result = testingInstance.findByClientId(CLIENT_ID);

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get()).isEqualTo(history);
	}

}
