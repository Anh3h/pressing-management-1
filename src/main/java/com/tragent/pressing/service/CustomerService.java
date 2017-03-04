package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.Customer;

/* Service that provides CRUD operations for customers  */
public interface CustomerService {
	
	/**
	 * Get all customers in the system.
	 * 
	 * @return collection of all customers in the system
	 */
	public Collection<Customer> findAll();
	
	/**
	 * Find a customer by Id.
	 * 
	 * @param id the customer's id
	 * @return the customer object if found, else return null
	 */
	public Customer findById(Long id);
	
	/**
	 * Find a customer by email.
	 * 
	 * @param email the customer's email
	 * @return the customer object if found, else return null
	 */
	public Customer findByEmail(String email);
	
	/**
	 * Create a new customer account.
	 * 
	 * @param customer, the customer account to be created
	 * @return the created customer account 
	 */
	public Customer create(Customer customer);
	
	/**
	 * Update an existing customer account's information.
	 * 
	 * @param customer the updated Customer's record
	 * @return the updated customer object
	 */
	public Customer update(Customer customer);
	
	/**
	 * Delete a customer account from the system.
	 * 
	 * @param id customer's id
	 */
	public void delete(Long id);
	
}
