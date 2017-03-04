package com.tragent.pressing.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tragent.pressing.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	Collection<Payment> findByCustomerItem(@Param("id") Long id);
	Collection<Payment> findByTime(@Param("time") Date time);

}
