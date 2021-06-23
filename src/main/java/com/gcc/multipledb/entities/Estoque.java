
package com.gcc.multipledb.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Estoque {
	
	@EmbeddedId
	private EstoqueId id;
					
	@ManyToOne	
	@JoinColumn(name="produto", referencedColumnName = "id", insertable = false, updatable = false)
	private Produto produto;
	
	//@ManyToOne		
	//@JoinColumn(name="filial", referencedColumnName = "id", insertable = false, updatable = false)
	//private Filial filial;
			
	@Column
	private Integer quantidade;
}