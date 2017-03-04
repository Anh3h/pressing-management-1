package com.tragent.pressing.service;

import java.util.Collection;
import java.util.Date;

import com.tragent.pressing.model.MaterialPurchase;

/* Service that provides CRUD operations for material purchases  */
public interface MaterialPurchaseService {
	
	/**
	 * Get all cleaning material purchases in the system.
	 * 
	 * @return collection of all material purchases existing in the system
	 */
	public Collection<MaterialPurchase> findAll();
	
	/**
	 * Find a material purchase by Id.
	 * 
	 * @param purchaseId
	 * @return the material purchase object if found, else return null
	 */
	public MaterialPurchase findById(Long id);
	
	/**
	 * Find a purchase by purchase date.
	 * 
	 * @param purchasedDate
	 * @return Collection of purchases
	 */
	public Collection<MaterialPurchase> findByPurchasDate(Date purchaseDate);
	

	/**
	 * Find a purchase by cleaning material.
	 * 
	 * @param materialId
	 * @return Collection of purchases
	 */
	public Collection<MaterialPurchase> findByCleaningMaterial(Long id);
	
	/**
	 * Create a new purchase.
	 * 
	 * @param purchase, the purchase transaction to be created
	 * @return the created purchase transaction 
	 */
	public MaterialPurchase create(MaterialPurchase purchase);
	
	/**
	 * Update an existing purchase.
	 * 
	 * @param purchase the updated purchase's record
	 * @return the updated purchase object
	 */
	public MaterialPurchase update(MaterialPurchase purchase);
	
}
