package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer> {
	
}
