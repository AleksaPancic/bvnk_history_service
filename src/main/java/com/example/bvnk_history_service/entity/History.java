package com.example.bvnk_history_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "history")
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;

	@Column(name = "client_id")
	private Long clientId; //reference to the client

	@Column(name = "history_name")
	private String historyName;

	@Column(name = "history_description")
	private String historyDescription;

	@Column(name = "history_content")
	private String historyContent;

}
