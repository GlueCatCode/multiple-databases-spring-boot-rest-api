package com.gcc.multipledb.entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Imagem {
	
	public Imagem(String nome, String cor, Integer indice){
		this.nome = nome;
		this.cor = cor;
		this.indice = indice;
	}
	
	public Imagem() {}
	
	private String nome;
	private String cor;
	private Integer indice;

}
