package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.EnderecoCliente;

public interface EnderecoRepository extends JpaRepository<EnderecoCliente , Integer> {
	
}
