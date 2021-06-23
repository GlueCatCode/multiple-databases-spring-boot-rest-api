package com.gcc.multipledb.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.gcc.multipledb.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>, JpaSpecificationExecutor<Produto> {
	
	@Query("select p.id from Produto p")
	Set<Integer> getAllIds();

	List<Produto> findByVersaoGreaterThanEqual(Long versao);
	
}
