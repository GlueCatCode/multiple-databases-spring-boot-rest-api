package com.gcc.multipledb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.gcc.multipledb.entities.types.PedidoTipoErp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table
public class PedidoTipo {
	
	@Id @Column
	private Integer id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PedidoTipoErp tipo;
	
	@Column
	private String descricao;
	
	@Column
	private Integer tipoFrete;
	
	@Column
	private Integer uploadFile;
	
	@Column
	private Boolean aprovado;
	
	@Column
	private Boolean orcamento;
	
	@Column
	private Boolean validaEstoque;
	
	@Column
	private Boolean precoDivergente;
	
	@Column
	private Boolean modalidadeFreteCF;
	
	@Column
	private Boolean aprovacaoCliente;
	
	@Column
	private Boolean noCheckout;
	
	@Column
	private Boolean obsNotaFiscal;
	
	@Column(columnDefinition="TEXT")
	private String observacao;
	
	@Column
	private Boolean ativo;
	
	//@ManyToMany
	//@JoinTable(name = "pedidotipo_frete", joinColumns = @JoinColumn(name = "pedidotipo_id"), inverseJoinColumns = @JoinColumn(name = "frete_id"))
	//private List<Frete> fretes;
	
	@ManyToMany
	@JoinTable(name = "pedidotipo_formapagamento", joinColumns = @JoinColumn(name = "pedidotipo_id"), inverseJoinColumns = @JoinColumn(name = "formapagamento_id"))
	private List<FormaPagamento> formaPagamentos;
}
