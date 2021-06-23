package com.gcc.multipledb.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.LinkShare;

public interface LinkShareRepository extends JpaRepository<LinkShare, String> {
	
	Optional<LinkShare> findByIdAndValidGreaterThan(String id, Date data);
	
}
