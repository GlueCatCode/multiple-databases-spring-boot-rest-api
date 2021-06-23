
package com.gcc.multipledb.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Preco {
	
	@EmbeddedId
	private PrecoId id;
					
	@ManyToOne		
	@JoinColumn(name="produto", referencedColumnName = "id", insertable = false, updatable = false)
	private Produto produto;
	
	@Column
	private BigDecimal preco;
	
	@Column
	private BigDecimal precoPromocional;
	
}