package com.tragent.pressing.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tragent.pressing.model.CustomerItem;

public interface CustomerItemRepository extends JpaRepository<CustomerItem, Long> {
	
	Collection<CustomerItem> findByDepositeDate(@Param("date") Date date);
	Collection<CustomerItem> findByDueDate(@Param("date") Date date);
	Collection<CustomerItem> findByCustomer(@Param("date") Long id );
	Collection<CustomerItem> findByItem(@Param("date") Long id );
}
