package com.gcc.multipledb.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gcc.multipledb.entities.types.TipoGerador;
import com.gcc.multipledb.entities.types.TipoPoliticaComercial;

import lombok.Data;

@Data
@Embeddable
public class PoliticaComercial {
	
	public PoliticaComercial() {}
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoPoliticaComercial tipo;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoGerador tipoGerador;
	
	@Column
	private Integer gerador;
	
	@Column(precision = 19, scale = 2)
	private BigDecimal acerto;
	
	@Column
	private Integer quantidade;
	
	@Column
	private Integer ordem;
	
}