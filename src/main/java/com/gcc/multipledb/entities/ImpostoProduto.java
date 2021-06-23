package com.gcc.multipledb.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ImpostoProduto {
	
	@Id
	private ImpostoProdutoId id ;
	@Column(precision = 19, scale = 4)
	private BigDecimal ipi;
	@Column(precision = 19, scale = 4)
	private BigDecimal alIcms;
	@Column(precision = 19, scale = 4)
	private BigDecimal alIcmsOrigem;
	@Column(precision = 19, scale = 4)
	private BigDecimal substIcms;
	
}