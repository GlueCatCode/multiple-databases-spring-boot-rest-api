package com.gcc.multipledb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PrecoId  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private Integer cor;
	
	@Column
	private Integer estampa;
	
	@Column(length = 10)
	private String tamanho;
	
	@Column
	private Integer produto;
	
	@Column
	private Integer tabela;

}