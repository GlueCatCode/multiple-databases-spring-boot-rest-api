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
public class Estampa {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String codigo;

	@Column
	private String descricao;
	
	@ManyToMany(mappedBy = "estampas")
	private List<Produto> produtos;
	
}