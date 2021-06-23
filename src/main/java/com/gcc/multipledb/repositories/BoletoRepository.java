package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Integer> {
	
	List<Boleto> findByClienteInAndAtivoTrue(List<Integer> clientes);
	
}
