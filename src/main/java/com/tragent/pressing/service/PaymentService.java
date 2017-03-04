package com.tragent.pressing.service;

import java.util.Collection;
import java.util.Date;

import com.tragent.pressing.model.Payment;

/* Service that provides CRUD operations for payments */
public interface PaymentService {

	/**
	 * Get all Payments made int the system.
	 * 
	 * @return collection of all payments made in the system
	 */
	public Collection<Payment> findAll();
	
	/**
	 * Get payment made by a customer for an item.
	 * 
	 * @param customer's id and item's id
	 * @return collection of payments
	 */
	public Collection<Payment> findByPaymentByCustomerItem(Long cutomerItemId);
	
	/**
	 * Get payment made on a particular time.
	 * 
	 * @param time, 
	 * @return collection of payments
	 */
	public Collection<Payment> findByPaymentByTime(Date time);
	
	/**
	 * Create payments made by a customer for an item.
	 * 
	 * @param new payment information
	 * @return the created payment 
	 */
	public Payment create(Payment payment);
	
	/**
	 * Update an existing Customer Item transaction's information.
	 * 
	 * @param updated payment information
	 * @return the updated customer-item object
	 */
	public Payment update(Payment payment);
	
}
