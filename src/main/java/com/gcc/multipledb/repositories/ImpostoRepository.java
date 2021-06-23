package com.gcc.multipledb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.ImpostoProduto;
import com.gcc.multipledb.entities.ImpostoProdutoId;

public interface ImpostoRepository extends JpaRepository<ImpostoProduto, ImpostoProdutoId> {

	List<ImpostoProduto> findByIdProduto(Integer idProduto);	
	
}
