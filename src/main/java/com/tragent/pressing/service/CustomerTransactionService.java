package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.CleaningTransaction;
import com.tragent.pressing.model.CustomerItem;
import com.tragent.pressing.model.Payment;

/* Service that provides CRUD operations for customer transactions  */
public interface CustomerTransactionService {
	
	/**
	 * Get all customer transactions in the system.
	 * 
	 * @return collection of all cleaning transaction in the system
	 */
	public Collection<CleaningTransaction> findAll();
	
	/**
	 * Find a cleaning transaction by custmer's Id.
	 * 
	 * @param id the customer's id
	 * @return the cleaning transaction object if found, else return null
	 */
	public CleaningTransaction findByCustomerId(Long id);
	
	/**
	 * Find a cleaning transaction by item's Id.
	 * 
	 * @param id the item's id
	 * @return the cleaning transaction object if found, else return null
	 */
	public CleaningTransaction findByItemId(Long id);
	
	/**
	 * Find cleaning transaction(s) by due date.
	 * 
	 * @param dueDate date to collect an item
	 * @return collection of transactions if found, else return null
	 */
	public Collection<CleaningTransaction> findByDueDate(String name);
	
	/**
	 * Find cleaning transaction(s) by deposite date.
	 * 
	 * @param depositeDate date an item  was deposited
	 * @return collection of transactions if found, else return null
	 */
	public Collection<CleaningTransaction> findByDepositeDate(String name);
	
	/**
	 * Get all payments for a transaction.
	 * 
	 * @param CustomerItem object
	 * @return collection of payment objects
	 */
	public Collection<Payment> getPayments(CustomerItem customerItem);
	
	/**
	 * Create new cleaning transaction.
	 * 
	 * @param cleaning transaction object
	 * @return the created transaction 
	 */
	public CleaningTransaction create(CleaningTransaction cleaningTransaction);
	
	/**
	 * Update an existing cleaning transactin's information.
	 * 
	 * @param cleaning transaction object
	 * @return the updated cleaning transaction object
	 */
	public CleaningTransaction update(CleaningTransaction cleaningTransaction);
	
}
