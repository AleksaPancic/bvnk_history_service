package com.example.bvnk_history_service.DTO;

import lombok.Value;


@Value
public class HistoryDto {
	private Long clientId;
	private String historyName;
	private String historyDescription;
	private String historyContent;
}
