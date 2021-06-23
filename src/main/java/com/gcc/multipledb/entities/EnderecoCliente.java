package com.gcc.multipledb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente_endereco")
public class EnderecoCliente {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@Column
	private Integer idEnderecoErp;
	
	@Column
	private String endereco;
	
	@Column
	private String numero;
	
	@Column
	private String cep;
	
	@Column
	private String bairro;
	
	@Column(length=3)
	private String uf;
	
	@Column(length=50)
	private String contato;

	@Column(length=3)
	private String ddd;
	
	@Column(length=20)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="cidade",referencedColumnName="id")
	private Cidade cidade;
	
	@Column
	private String cidadeEx;
	
	@Column
	private String ufEx;

}
