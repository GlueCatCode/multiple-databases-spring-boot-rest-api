package com.gcc.multipledb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcc.multipledb.entities.SliderPrincipal;

public interface SliderPrincipalItemRepository extends JpaRepository<SliderPrincipal, Integer> {
	
}
