package com.gcc.multipledb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Departamento {

	@Id @Column
	private Integer id;
	
	@Column
	private String codigo;
	
	@Column
	private String descricao;
	
}