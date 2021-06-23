package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer> {

	List<FormaPagamento> findByAtivoIsTrue();
	
}
