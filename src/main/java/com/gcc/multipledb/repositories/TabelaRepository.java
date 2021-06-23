package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Tabela;

public interface TabelaRepository extends JpaRepository<Tabela, Integer>{

	List<Tabela> findByAtivoIsTrue();
	
}
