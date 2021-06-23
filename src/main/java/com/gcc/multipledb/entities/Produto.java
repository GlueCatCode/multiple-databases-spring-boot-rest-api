package com.gcc.multipledb.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table
public class Produto {

	@Id
	@Column
	private Integer id;
	
//	@Column
//	private String teste;

	@Column
	private String referencia;

	@Column
	private String descricao;
	
	@Column
	private Boolean ativo;
	
	@Column(columnDefinition="TEXT")
	private String observacoes;
	
	@Column(columnDefinition="TEXT")
	private String observacoesSite;
	
	@Column(columnDefinition="TEXT")
	private String busca;
	
	@Column
	private Integer grade;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@OneToMany(mappedBy = "produto")
	private List<Estoque> estoque;
	
	@OneToMany(mappedBy = "produto")
	private List<Preco> preco;
	
	@ManyToMany
	@JoinTable(name = "produto_especificacao", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "especificacao_id"))
	private List<Especificacao> especificacoes;

	@ManyToMany
	@JoinTable(name = "produto_cor", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "cor_id"))
	private List<Cor> cores;
	
	@ManyToMany
	@JoinTable(name = "produto_estampa", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "estampa_id"))
	private List<Estampa> estampas;
	
	@ElementCollection
	@OrderBy("indice")
	private List<Tamanho> tamanhos;
	
	@ElementCollection
	@OrderBy("indice")
	private List<Imagem> imagens;

	@ManyToOne
	@JoinColumn(name = "categoria", referencedColumnName = "id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "colecao", referencedColumnName = "id")
	private Colecao colecao;

	@ManyToOne
	@JoinColumn(name = "departamento", referencedColumnName = "id")
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name = "divisao", referencedColumnName = "id")
	private Divisao divisao;

	@ManyToOne
	@JoinColumn(name = "grupo", referencedColumnName = "id")
	private Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "marca", referencedColumnName = "id")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "tipo", referencedColumnName = "id")
	private Tipo tipo;
	
	@Column
	private BigDecimal peso;
	@Column
	private BigDecimal largura;
	@Column
	private BigDecimal altura;
	@Column
	private BigDecimal comprimento;
	
	@Column
	private Integer multiplo;
	
	@Column
	private Long versao;
	
}