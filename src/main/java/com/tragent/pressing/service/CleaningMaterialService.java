package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.Category;
import com.tragent.pressing.model.CleaningMaterial;

/* Service that provides CRUD operations for cleaning materials  */
public interface CleaningMaterialService {

	/**
	 * Get all cleaning materials in the system.
	 * 
	 * @return collection of all cleaning materials in the system
	 */
	public Collection<CleaningMaterial> findAll();
	
	/**
	 * Find a cleaning material by Id.
	 * 
	 * @param id the cleaning material's id
	 * @return the cleaning material object if found else return null
	 */
	public CleaningMaterial findById(Long id);
	
	/**
	 * Find a cleaning material by name.
	 * 
	 * @param name the cleaning material's name
	 * @return the cleaning material object if found else return null
	 */
	public CleaningMaterial findByName(String name);
	
	/**
	 * Find a cleaning material by category.
	 * 
	 * @param category the cleaning material's category
	 * @return collection of cleaning materials
	 */
	public Collection<CleaningMaterial> findByCategory(Long categoryId);
	
	/**
	 * Create a new cleaning material object.
	 * 
	 * @param CleaningMaterial object to be created
	 * @return the created CleaningMaterial
	 */
	public CleaningMaterial create(CleaningMaterial cleaningMaterial);
	
	/**
	 * Update an existing cleaningMaterial object.
	 * 
	 * @param CleaningMaterial the updated cleaning material object
	 * @return the updated cleaning material object
	 */
	public CleaningMaterial update(CleaningMaterial cleaningMaterial);
	
	/**
	 * Delete a CleaningMaterial from the system
	 * 
	 * @param id cleaning materials's id
	 */
	public void delete(Long id);
}
