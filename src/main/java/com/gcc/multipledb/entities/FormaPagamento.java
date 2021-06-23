package com.gcc.multipledb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class FormaPagamento {
	
	@Id @Column
	private Integer id;
	
	@Column
	private String codigo;
	
	@Column
	private String descricao;
	
	@Column
	private Boolean ativo;
	
	@ElementCollection
	@OrderBy("ordem")
	private List<PoliticaComercial> politicas;
	
}