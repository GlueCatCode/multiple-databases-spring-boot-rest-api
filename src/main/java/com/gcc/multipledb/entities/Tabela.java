package com.gcc.multipledb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table
public class Tabela {
	
	@Id @Column
	private Integer id;
	
	@Column
	private String codigo;
	
	@Column
	private String descricao;
	
	@Column
	private String tipo;
		
	@Column
	private Boolean ativo;
	
}
