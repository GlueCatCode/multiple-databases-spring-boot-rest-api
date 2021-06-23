package com.gcc.multipledb.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table
public class Boleto {
	
	@Id	
	@Column
	private Integer lancamento;
	
	@Column
	private Integer cliente;
	
	@Column
	private String numeroDocumento;
	
	@Column
	private String nossoNumero;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column
	private BigDecimal valorBoleto;

	@Column
	private String sacadoNome;
	
	@Column
	private String sacadoCnpj;
	
	@Column
	private String sacadoCep;
	
	@Column
	private String sacadoBairro;
	
	@Column
	private String sacadoLogradouro;
	
	@Column
	private String sacadoCidade;
	
	@Column
	private String sacadoEstado;
	
	@Column
	private String codBanco;
	
	@Column
	private String conta;
	
	@Column
	private String agencia;
	
	@Column
	private String carteira;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	
	@Column
	private String cedenteNome;
	
	@Column
	private String cedenteCnpj;
	
	@Column
	private String instrucao1;
	
	@Column
	private String instrucao2;
	
	@Column
	private String instrucao3;
	
	@Column
	private Boolean ativo;

}