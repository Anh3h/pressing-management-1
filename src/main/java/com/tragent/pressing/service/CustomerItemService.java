package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.CustomerItem;

/* Service that provides CRUD operations for customer-item */
public interface CustomerItemService {
	
	/**
	 * Get all customer item transactions in the system.
	 * 
	 * @return collection of all customer-item relationship in the system
	 */
	public Collection<CustomerItem> findAll();
	
	/**
	 * Find a customer-item transaction by customer id.
	 * 
	 * @param id, the customer's id
	 * @return collection of customer-item transaction for the given customer
	 */
	public Collection<CustomerItem> findByCustomerId(Long id);
	
	/**
	 * Find a customer-item transaction by item id.
	 * 
	 * @param id, the item's id
	 * @return collection of customer-item transaction for the given item
	 */
	public Collection<CustomerItem> findByItemId(Long id);
	
	/**
	 * Create a new customer-Item transaction.
	 * 
	 * @param customer, the Customer-item account to be created
	 * @return the created customer-item account 
	 */
	public CustomerItem create(CustomerItem customerItem);
	
	/**
	 * Update an existing Customer Item transaction's information.
	 * 
	 * @param customer-item transaction the updated customer-item record
	 * @return the updated customer-item object
	 */
	public CustomerItem update(CustomerItem customerItem);
	
}
