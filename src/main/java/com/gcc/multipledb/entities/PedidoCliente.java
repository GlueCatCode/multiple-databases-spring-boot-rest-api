package com.gcc.multipledb.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.gcc.multipledb.entities.types.PedidoClienteStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pedido_cliente")
public class PedidoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private Integer idEnderecoErp;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PedidoClienteStatus status;
	
	@Column
	private String statusERP;
	
	@ElementCollection
	@OrderBy("data")
	private List<PedidoClienteInfo> infos;
	
	@ManyToOne
	@JoinColumn(name = "pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@Column
	private Integer quantidade;
	@Column(precision = 19, scale = 4)
	private BigDecimal subtotal;
	@Column(precision = 19, scale = 4)
	private BigDecimal impostos;
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
	private Integer idErpCompra;
	@Column
	private String codigoErpCompra;
	@Column
	private Integer idErpVenda;
	@Column
	private String codigoErpVenda;
	@Column
	private Integer idErpTransferencia;
	@Column
	private String codigoErpTransferencia;
	
	@Column
	private Boolean aprovado;

}