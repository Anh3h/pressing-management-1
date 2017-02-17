package com.tragent.pressing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tragent.pressing.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>  {

	Item findByName(@Param("name") String name);
	
}
