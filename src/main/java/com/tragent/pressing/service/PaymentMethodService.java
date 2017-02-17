package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.PaymentMethod;


/* Service that provides CRUD operation for payment methods  */
public interface PaymentMethodService {

	/**
	 * Get all payment methods in the system.
	 * 
	 * @return collection of all payment methods in the system
	 */
	public Collection<PaymentMethod> findAll();
	
	/**
	 * Find a payment method by Id.
	 * 
	 * @param id the payment method's id
	 * @return the PaymentMethod object if found, else return null
	 */
	public PaymentMethod findById(Long id);
	
	/**
	 * Find a payment method by name.
	 * 
	 * @param name, the payment method's name
	 * @return the payment method object if found, else return null
	 */
	public PaymentMethod findByName(String name);
	
	/**
	 * Create new payment method.
	 * 
	 * @param payment method, the payment method to be created
	 * @return the created payment method 
	 */
	public PaymentMethod create(PaymentMethod paymentMethod);
	
	/**
	 * Update an existing payment method's information.
	 * 
	 * @param payment method, the updated payment method's record
	 * @return the updated payment method object
	 */
	public PaymentMethod update(PaymentMethod paymentMethod);
	
	/**
	 * Delete a payment method from the system.
	 * 
	 * @param id, payment method's id
	 */
	public void delete(Long id);
	
	
}
