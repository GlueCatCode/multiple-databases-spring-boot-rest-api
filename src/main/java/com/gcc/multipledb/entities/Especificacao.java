package com.gcc.multipledb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table
public class Especificacao {
	
	@Id
	@Column
	private Integer id;

	@Column
	private String nome;
	
	@Column(columnDefinition="TEXT")
	private String descricao;
	
	@Column
	private Boolean caracteristica;
	
	@Column
	private Boolean filtro;
	
	@ManyToMany(mappedBy = "especificacoes")
	private List<Produto> produtos;
		
}