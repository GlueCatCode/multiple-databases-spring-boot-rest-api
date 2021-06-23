package com.gcc.multipledb.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.Data;

@Data
@Entity
public class Configuracao {

	@Id @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//////////////////////////////////////////////////
	//Sitema
	//////////////////////////////////////////////////
	@Column
	private String labelCliente;
	@Column
	private String labelFilial;
	@Column
	private String labelTabela;
	@Column
	private String labelPedidoTipo;
	@Column
	private String identificacaoCliente;
	@Column
	private Integer tipoPoliticaComercial;
	@Column
	private Integer tabelaPadrao;
	@Column
	private Boolean mostraProdutoSemEstoque;
	@Column
	private Boolean mostraProdutoSemPreco;
	@Column
	private Boolean mostraPrecoPedidoSelecionado;
	@Column
	private Boolean mostraCorProdutoIndisponivel;
	@Column
	private Boolean mostraSomaCaracteristicaCatalogo;
	@Column
	private Boolean mostraEstoqueDigitacao;
	@Column
	private Boolean validaEstoqueDigitacao;
	@Column
	private Integer quantidadeMaximaGrade;
	@Column(columnDefinition="TEXT")
	private String appendHeadAfterLogin;
	@Column
	private Boolean mostraCopyright;
	@Column
	private Integer tempoLinkShare;
	@Column
	private Boolean mostraPrecoLinkShare;
	@Column
	private Boolean carrinhoCodigoBarras;
	@Column(columnDefinition="TEXT")
	private String catalogo;
	@Column
	private Boolean catalogoInclusivo;
	@Column
	private Integer quantidadePedidoClienteAberto;
	@Column
	private Integer quantidadePedidoUsuarioAberto;
	@Column
	private Boolean mostraDataEntrega;
	@Column
	private Integer dataEntregaHorarioLimite;
	@Column
	private String dataEntregaDiasDesabilitados;
	@Column
	private Integer dataEntregaCarenciaPrazo;
	@Column
	private Boolean cliente;
	/*@Column
	private String freteApiLink;
	@Column
	private String freteApiKey;*/
	@Column
	private Integer tabelaSugerido;
	@Column
	private Boolean mostraDisponivelCatalogo;
	@Column
	private Integer precoDivergenteTabelaMin;
	@Column
	private Integer precoDivergenteTabelaIdeal;
	
	// Pedido - ao enviar json erp, considerar vendedor e cliente:
	// 1 = Vendedor e Representante do Cliente
	// 2 = Vendedor e Representante do Usuário
	@Column
	private Integer pedidoVendedorRepresentante;
	
	@Column
	private Boolean salvaCheckout;
	
	@Column
	private String infoCabecalhoReport;
	
	//////////////////////////////////////////////////
	//Email
	//////////////////////////////////////////////////
	@Column
	private String emailHost;
	@Column
	private String emailUser;
	@Column
	private String emailPass;
	@Column
	private String emailFrom;
	@Column
	private String emailLink;
	@Column
	private Integer emailPort;
	@Column
	private Boolean emailSmtpAuth;
	@Column
	private Boolean emailTlsAuth;
	
	//////////////////////////////////////////////////
	//Metatags
	//////////////////////////////////////////////////
	@Column
	private String title;
	@Column
	private String metatagDescription;
	@Column
	private String metatagAbstract;
	
	//////////////////////////////////////////////////
	//Tema
	//////////////////////////////////////////////////
	@Column
	private String theme;
	@Column
	private String font;
	@Column
	private Integer fontSize;
	@Column
	private Integer borderRadius;
	@Column
	private String iconCart;
	@Column
	private String iconSearch;
	
	//////////////////////////////////////////////////
	//Components
	//////////////////////////////////////////////////
	////////////////////
	@Column
	private Boolean isSliderSuperior;
	@Column
	private Integer intervalSliderSuperior;
	@Column
	private Integer fontSizeSliderSuperior;
	@Column
	private String backgroundColorSliderSuperior;
	@ElementCollection
	private List<String> sliderSuperior;
	////////////////////
	@Column
	private Boolean fadeSliderPrincipal;
	@Column
	private Integer intervalSliderPrincipal;
	@Column
	private Boolean ballIndicatorSliderPrincipal;
	@Column
	private Boolean mousePauseSliderPrincipal;
	@OneToMany
	@JoinColumn(name = "sliderPrincipal", referencedColumnName = "id")
	@OrderBy("ordem ASC")
	private List<SliderPrincipal> sliderPrincipal;
	////////////////////
	@Column
	private String titleSliderProdutos;
	@Column
	private Boolean dotsSliderProdutos;
	@Column
	private Boolean infiniteSliderProdutos;
	@Column
	private Integer intervalSliderProdutos;
	////////////////////
	@Column(columnDefinition="TEXT")
	private String homeHTML;
	////////////////////
	@Column
	private String institucionalTitle1;
	@Column
	private String institucionalTitle2;
	
	@OneToMany
	@JoinColumn(name = "infoPage", referencedColumnName = "id")
	private List<InfoPageWithoutHtml> infoPage;
	
	//////////////////////////////////////////////////
	//Mídias Sociais
	//////////////////////////////////////////////////
	@Column(columnDefinition="TEXT")
	private String midiasSociais;
	
	//////////////////////////////////////////////////
	//Onde estamos
	//////////////////////////////////////////////////
	@Column(columnDefinition="TEXT")
	private String ondeEstamos;
	
	//////////////////////////////////////////////////
	//Produto
	//////////////////////////////////////////////////
	@Column
	private String produtoStyle;
	
}