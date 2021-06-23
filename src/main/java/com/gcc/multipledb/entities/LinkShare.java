package com.gcc.multipledb.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class LinkShare {

	@Id @Column
	private String id;
	
	@Column(columnDefinition="TEXT")
	private String share;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date valid;
		
}