package com.tragent.pressing.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tragent.pressing.model.Category;
import com.tragent.pressing.model.CleaningMaterial;

public interface CleaningMaterialRepository extends JpaRepository<CleaningMaterial, Long> {

	CleaningMaterial findByName(@Param("name") String name);
	Collection<CleaningMaterial> findByCategory(@Param("category") Category category );
	
}
