package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.gcc.multipledb.entities.Pedido;
import com.gcc.multipledb.entities.Usuario;
import com.gcc.multipledb.entities.types.PedidoStatus;
import com.gcc.multipledb.entities.types.PedidoTipoErp;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>, JpaSpecificationExecutor<Pedido> {

	@Query("select p from Pedido p where p.tipo.tipo = :tipo and p.status = :status")
	List<Pedido> findByTipoAndStatus(PedidoTipoErp tipo, PedidoStatus status);
	
	Integer countByStatusAndOwner(PedidoStatus status, Usuario usuario);
	
}
