package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.Permission;

/* Service that provides CRUD operations for permission */
public interface PermissionService {
	
	/**
	 * Get all permissions in the system.
	 * 
	 * @return collection of all permissions in the system
	 */
	public Collection<Permission> findAll();
	
	/**
	 * Find a permission by Id.
	 * 
	 * @param permissionId
	 * @return the permission object if found, else return null
	 */
	public Permission findById(Long id);
	
	/**
	 * Find a permission by name.
	 * 
	 * @param name the permission's name
	 * @return the permission object if found, else return null
	 */
	public Permission findByName(String name);
	
	/**
	 * Create a new permission.
	 * 
	 * @param permission, the permission to be created
	 * @return the created permission 
	 */
	public Permission create(Permission permission);
	
	/**
	 * Update an existing permission.
	 * 
	 * @param permission the updated permission record
	 * @return the updated permission object
	 */
	public Permission update(Permission permission);
	
}
