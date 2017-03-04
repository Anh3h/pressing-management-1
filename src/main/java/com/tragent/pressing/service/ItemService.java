package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.Item;

/* Service that provides CRUD operations for items  */
public interface ItemService {
	
	/**
	 * Get all items in the system.
	 * 
	 * @return collection of all items in the system
	 */
	public Collection<Item> findAll();
	
	/**
	 * Find an item by Id.
	 * 
	 * @param id the item's id
	 * @return the item object if found, else return null
	 */
	public Item findById(Long id);
	
	/**
	 * Find an item by name.
	 * 
	 * @param name the item's name
	 * @return the item object if found, else return null
	 */
	public Item findByName(String name);
	
	/**
	 * Find a items with same category.
	 * 
	 * @param name the category's id
	 * @return the item object if found else return null
	 */
	public Collection<Item> findCategoryItems(Long id);
	
	/**
	 * Create new Item.
	 * 
	 * @param item the item to be created
	 * @return the created item 
	 */
	public Item create(Item item);
	
	/**
	 * Update an existing item's information.
	 * 
	 * @param item the updated item's record
	 * @return the updated item object
	 */
	public Item update(Item item);
	
	/**
	 * Delete a item from the system.
	 * 
	 * @param id item's id
	 */
	public void delete(Long id);
	
}
