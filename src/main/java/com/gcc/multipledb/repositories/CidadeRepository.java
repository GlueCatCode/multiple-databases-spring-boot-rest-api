package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Cidade;
import com.gcc.multipledb.entities.types.UF;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	List<Cidade> findByUf(UF uf);
	
}
