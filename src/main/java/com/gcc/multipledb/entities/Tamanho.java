package com.gcc.multipledb.entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Tamanho {
	
	private String tamanho;
	private Integer indice;

}
