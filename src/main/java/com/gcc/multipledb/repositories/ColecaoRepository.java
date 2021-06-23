package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.Colecao;

public interface ColecaoRepository extends JpaRepository<Colecao, Integer> {

}
