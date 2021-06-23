package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.PedidoTipo;

public interface PedidoTipoRepository extends JpaRepository<PedidoTipo, Integer>{

	List<PedidoTipo> findByAtivoIsTrue();
	
}
