package com.example.bvnk_history_service.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "history")
@Getter
@Setter
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
