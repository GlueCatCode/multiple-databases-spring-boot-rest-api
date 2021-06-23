package com.gcc.multipledb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ImpostoProdutoId implements Serializable {
	private static final long serialVersionUID = 1L;
	public Integer produto;
	public String estado;
}