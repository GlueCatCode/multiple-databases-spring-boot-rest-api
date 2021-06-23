package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Estoque;
import com.gcc.multipledb.entities.EstoqueId;

public interface EstoqueRepository extends JpaRepository<Estoque, EstoqueId> {

}
