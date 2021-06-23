package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Filial;

public interface FilialRepository extends JpaRepository<Filial, Integer> {
	
}
