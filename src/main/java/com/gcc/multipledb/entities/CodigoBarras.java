
package com.gcc.multipledb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class CodigoBarras {
	
	@Id	
	@Column
	private String barra;
	
	@Column
	private Integer produto;
	
	@Column
	private Integer cor;
	
	@Column
	private Integer estampa;
	
	@Column(length = 10)
	private String tamanho;

}