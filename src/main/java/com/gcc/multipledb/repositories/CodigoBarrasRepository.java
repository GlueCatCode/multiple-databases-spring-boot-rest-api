package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.CodigoBarras;

public interface CodigoBarrasRepository extends JpaRepository<CodigoBarras, String> {

}
