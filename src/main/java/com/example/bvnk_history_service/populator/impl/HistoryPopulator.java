package com.example.bvnk_history_service.populator.impl;

import com.example.bvnk_history_service.DTO.HistoryDto;
import com.example.bvnk_history_service.entity.History;
import com.example.bvnk_history_service.populator.Populator;
import org.springframework.stereotype.Component;


@Component
public class HistoryPopulator implements Populator<HistoryDto, History> {

	@Override
	public void populate(HistoryDto source, History target) {
		target.setClientId(source.getClientId());
		target.setHistoryContent(source.getHistoryContent());
		target.setHistoryDescription(source.getHistoryDescription());
		target.setHistoryName(source.getHistoryName());
	}

}
