package com.gcc.multipledb.entities;
	
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.gcc.multipledb.entities.types.TipoUsuario;

import lombok.Data;
import lombok.EqualsAndHashCode;
	
@Entity
@EqualsAndHashCode(of = "id")
@Data
public class Usuario {
	
	@Id @Column
	private Integer id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	@Column
	private String nome;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column
	private Boolean ativo;
	
	@Column
	private Integer vendedor;
	
	@Column
	private Integer representante;
	
	@ManyToMany
	@JoinTable(name = "usuario_cliente", joinColumns = {@JoinColumn(name = "usuario_id")}, inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private List<Cliente> clientes;
	
	@ManyToMany
	@JoinTable(name = "usuario_tabela", joinColumns = {@JoinColumn(name = "usuario_id")}, inverseJoinColumns = @JoinColumn(name = "tabela_id"))
	private List<Tabela> tabelas;
	
	@ManyToMany
	@JoinTable(name = "usuario_pedidotipo", joinColumns = {@JoinColumn(name = "usuario_id")}, inverseJoinColumns = @JoinColumn(name = "pedidotipo_id"))
	private List<PedidoTipo> pedidoTipos;
	
}
