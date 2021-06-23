package com.gcc.multipledb.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "configuracao_infopage")
public class InfoPageWithoutHtml {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String pageId;
	
	@Column
	private String label;
	
	@Column
	private Integer groupId;
	
	@Column
	private Integer ordem;
	
}
