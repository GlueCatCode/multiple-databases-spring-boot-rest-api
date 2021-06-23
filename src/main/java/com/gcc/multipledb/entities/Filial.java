package com.gcc.multipledb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table
public class Filial {

	@Id @Column
	private Integer id;
	
	@Column
	private Integer idFornecedorErp;
	
	@Column
	private String codigo;
	
	@Column
	private String descricao;
	
	@Column
	private String cnpj;
	
	@Column
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(name = "filial_tabela", joinColumns = @JoinColumn(name = "filial_id"), inverseJoinColumns = @JoinColumn(name = "tabela_id"))
	private List<Tabela> tabelas;
	
	@ManyToMany
	@JoinTable(name = "filial_formapagamento", joinColumns = @JoinColumn(name = "filial_id"), inverseJoinColumns = @JoinColumn(name = "formapagamento_id"))
	private List<FormaPagamento> formaPagamentos;
	
}