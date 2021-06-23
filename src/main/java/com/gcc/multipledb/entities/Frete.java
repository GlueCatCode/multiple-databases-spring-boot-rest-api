package com.gcc.multipledb.entities;

import java.math.BigDecimal;

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
public class Frete {
	
	@Id @Column
	private Integer id;
	
	@Column
	private Integer idTransportadora;
	
	@Column
	private String codigoEmpresa;
	
	@Column
	private String codigoServico;
	
	@Column
	private String moduloAPI;
	
	@Column
	private String descricao;
	
	@Column
	private String cepOrigem;
	
	@Column
	private String apiKey;
	
	@Column
	private String apiLink;
	
	@Column
	private String apiid;
	
	@Column
	private BigDecimal valor;
	
	@Column
	private Integer ordem;
	
	@Column
	private Boolean ativo;
	
}
