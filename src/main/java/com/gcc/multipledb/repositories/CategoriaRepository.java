package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
}
