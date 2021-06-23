package com.gcc.multipledb.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gcc.multipledb.entities.types.TipoDocumento;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "idErp")
@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private Integer idErp;

	@Column
	private Integer idEnderecoErp;
	
	@Column
	private Integer idfilialErp;
	
	@Column
	private Integer vendedor;
	
	@Column
	private Integer representante;

	@Column
	private String codigo;
	
	@Column
	private String nome;
	
	@Column
	private String fantasia;

	@Column
	private String email;
	
	@Column
	private String complemento;
	
	@Column
	private Integer tipoEmpresa;

	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Column
	private String ddd;
	
	@Column
	private String telefone;
	
	@Column
	private Boolean bloqueiaPedidos;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	@Column
	private String numDocumento;
	
	@Column
	private String numDocumento1;
	
	@Column
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name="cidade",referencedColumnName="id")
	private Cidade cidade;
	
	@Column
	private String cidadeEx;
	
	@Column
	private String ufEx;
	
	@Column
	private String endereco;
	
	@Column
	private String numero;
	
	@Column	
	private String cep;
	
	@Column
	private String bairro;
	
	@Column
	private String contato;
	
	@Column
	private Integer registro;

	@ManyToMany
	@JoinTable(name = "cliente_tabela", joinColumns = @JoinColumn(name = "cliente_id"), inverseJoinColumns = @JoinColumn(name = "tabela_id"))
	private List<Tabela> tabelas;
	
	@OneToMany(mappedBy = "cliente")
	private List<EnderecoCliente> enderecos;
	
	@ManyToMany(mappedBy = "clientes")
	private List<Usuario> usuarios;

}
