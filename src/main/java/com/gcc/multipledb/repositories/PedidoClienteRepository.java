package com.gcc.multipledb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.gcc.multipledb.entities.Cliente;
import com.gcc.multipledb.entities.PedidoCliente;
import com.gcc.multipledb.entities.Usuario;
import com.gcc.multipledb.entities.types.PedidoClienteStatus;

public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, Integer>, JpaSpecificationExecutor<PedidoCliente> {
	
	@Query("select pc from PedidoCliente pc where pc.idErpCompra = :idErp or pc.idErpVenda = :idErp or pc.idErpTransferencia = :idErp")
	Optional<PedidoCliente> findByIdErp(Integer idErp);
	
	@Query("select distinct pc.statusERP from PedidoCliente pc where pc.statusERP != null and pc.status = :status order by pc.statusERP asc")
	List<String> findByDistinctStatusErpByStatus(PedidoClienteStatus status);
	
	Integer countByStatusAndClienteAndPedidoOwner(PedidoClienteStatus status, Cliente cliente, Usuario usuario);
	
}
