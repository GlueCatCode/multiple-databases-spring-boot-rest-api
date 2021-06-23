package com.gcc.multipledb.entities;

import java.util.Date;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class PedidoClienteInfo {
	
	private Integer idErp;
	private String codigoErp;
	private Integer status;
	private String statusDescricao;
	private String nfs;
	private String numeroObjeto;
	private String chaveNfe;
	private Date data;

}