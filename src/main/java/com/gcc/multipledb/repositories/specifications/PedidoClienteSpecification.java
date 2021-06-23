package com.gcc.multipledb.repositories.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.gcc.multipledb.entities.PedidoCliente;
import com.gcc.multipledb.entities.types.PedidoClienteStatus;

public class PedidoClienteSpecification {
	
	public static Specification<PedidoCliente> ownerId(Integer ownerId) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("pedido").get("owner").get("id"), ownerId);		
	}
	
	public static Specification<PedidoCliente> status(PedidoClienteStatus status) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("status"), status);		
	}
	
	public static Specification<PedidoCliente> clienteId(Integer clienteId) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("cliente").get("id"), clienteId);		
	}
	
	public static Specification<PedidoCliente> between(Date inicio, Date fim) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.between(root.get("pedido").get("data"), inicio, fim);		
	}
	
	public static Specification<PedidoCliente> statusERP(String statusERP) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("statusERP"), statusERP);		
	}

}
