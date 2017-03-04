package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.Role;

/* Service that provides CRUD operations for role */
public interface RoleService {
	
	/**
	 * Get all roles in the system.
	 * 
	 * @return collection of all roles in the system
	 */
	public Collection<Role> findAll();
	
	/**
	 * Find a role by Id.
	 * 
	 * @param roleId
	 * @return the role object if found, else return null
	 */
	public Role findById(Long id);
	
	/**
	 * Find a role by name.
	 * 
	 * @param name the role's name
	 * @return the role object if found, else return null
	 */
	public Role findByName(String name);
	
	/**
	 * Create a new role.
	 * 
	 * @param role, the role to be created
	 * @return the created role 
	 */
	public Role create(Role role);
	
	/**
	 * Update an existing role.
	 * 
	 * @param role the updated role's record
	 * @return the updated role object
	 */
	public Role update(Role role);
	
}
