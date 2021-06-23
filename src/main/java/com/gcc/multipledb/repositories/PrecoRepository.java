package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Preco;
import com.gcc.multipledb.entities.PrecoId;

public interface PrecoRepository extends JpaRepository<Preco, PrecoId> {

}
