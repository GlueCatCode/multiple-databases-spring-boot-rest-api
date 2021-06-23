package com.gcc.multipledb.entities;
	
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gcc.multipledb.entities.types.PedidoStatus;

import lombok.Data;
	
@Data
@Entity
@Table
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataAberto;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	
	@Column(columnDefinition="TEXT")
	private String observacao;
	
	@Column(columnDefinition="TEXT")
	private String observacaoNota;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PedidoStatus status;
	
	@ManyToOne
	@JoinColumn(name = "tipo", referencedColumnName = "id")
	private PedidoTipo tipo;
	
	@ManyToOne
	@JoinColumn(name = "tabela", referencedColumnName = "id")
	private Tabela tabela;
	
	@ManyToOne
	@JoinColumn(name = "filial", referencedColumnName = "id")
	private Filial filial;
	
	/*@ManyToOne
	@JoinColumns({
        @JoinColumn(name = "owner_id", referencedColumnName = "id"),
        @JoinColumn(name = "owner_tipo", referencedColumnName = "tipo")
	})*/
	@ManyToOne
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private Usuario owner;
	
	@ManyToOne
	@JoinColumn(name = "formaPagamento", referencedColumnName = "id")
	private FormaPagamento formaPagamento;
	
	@OneToMany(mappedBy = "pedido")
	@OrderBy("id DESC")
	private List<PedidoItem> pedidoItem;
	
	@OneToMany(mappedBy = "pedido")
	@OrderBy("id ASC")
	private List<PedidoCliente> pedidoCliente;
	
	@Column
	private Integer quantidade;
	@Column(precision = 19, scale = 4)
	private BigDecimal subtotal;
	@Column(precision = 19, scale = 4)
	private BigDecimal impostos;
	@Column(precision = 19, scale = 4)
	private BigDecimal acrescimo;
	@Column(precision = 19, scale = 4)
	private BigDecimal desconto;
	@Column(precision = 19, scale = 4)
	private BigDecimal total;
	
	@Column
	private Integer frete;
	@Column(precision = 19, scale = 4)
	private BigDecimal freteValor;
	@Column
	private String freteCepDestino;
	@Column
	private String freteDescr;
	@Column
	private String freteNome;
	@Column
	private String freteSobrenome;
	@Column
	private Integer freteModalidade;
	
	@Column(columnDefinition="TEXT")
	private String file1;
	
	@Column
	private Integer versao;
	
	@Column
	private Boolean integracaoError;
	
	@Column(columnDefinition="TEXT")
	private String integracaoMessage;
	
	@Column
	private Integer precoDivergenteStatus;
	
	@Column
	private Boolean salvoCheckout;
	
}	
	