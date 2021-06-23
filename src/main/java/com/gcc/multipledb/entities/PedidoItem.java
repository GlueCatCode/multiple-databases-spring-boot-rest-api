package com.gcc.multipledb.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pedido_item")
public class PedidoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	@JoinColumn(name = "produto", referencedColumnName = "id")
	@OneToOne
	private Produto produto;

	@Column
	private Integer cor;
	@Column
	private Integer estampa;
	@Column
	private String tamanho;
	@Column
	private Integer cliente;
	@Column
	private Integer quantidade;
	@Column(precision = 19, scale = 4)
	private BigDecimal preco;
	@Column(precision = 19, scale = 4)
	private BigDecimal acrescimo;
	@Column(precision = 19, scale = 4)
	private BigDecimal acrescimoPercent;
	@Column(precision = 19, scale = 4)
	private BigDecimal desconto;
	@Column(precision = 19, scale = 4)
	private BigDecimal descontoPercent;
	@Column(precision = 19, scale = 4)
	private BigDecimal total;
	
	@Column
	private String imp_estado;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_ipi;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_alicms;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_alicmsorigem;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_substicms;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_baseipi;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_basesubst;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_valoripi;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_valorsubst;
	@Column(precision = 19, scale = 4)
	private BigDecimal imp_valorimposto;
	
	@Column
	private String codigoBarras;

}