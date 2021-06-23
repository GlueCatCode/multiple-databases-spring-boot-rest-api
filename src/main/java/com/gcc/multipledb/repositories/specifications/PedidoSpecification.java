package com.gcc.multipledb.repositories.specifications;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.gcc.multipledb.entities.Pedido;
import com.gcc.multipledb.entities.types.PedidoStatus;

public class PedidoSpecification {
	
	public static Specification<Pedido> ownerId(Integer ownerId) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("owner").get("id"), ownerId);		
	}
	
	public static Specification<Pedido> status(PedidoStatus status) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("status"), status);		
	}
	
	public static Specification<Pedido> clienteId(Integer clienteId) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.join("pedidoCliente").get("cliente").get("id"), clienteId);		
	}
	
	public static Specification<Pedido> between(Date inicio, Date fim) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.between(root.get("dataAberto"), inicio, fim);		
	}
	
	public static Specification<Pedido> salvoCheckout(Boolean salvoCheckout) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("salvoCheckout"), salvoCheckout);		
	}

}
