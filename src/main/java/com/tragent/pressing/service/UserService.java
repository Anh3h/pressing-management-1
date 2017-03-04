package com.tragent.pressing.service;

import java.util.Collection;

import com.tragent.pressing.model.CustomUser;

/* Service that provides CRUD operations for users  */
public interface UserService {

	/**
	 * Get all users in the system.
	 * 
	 * @return collection of all users in the system
	 */
	public Collection<CustomUser> findAll();
	
	/**
	 * Find an user by Id.
	 * 
	 * @param id the user's id
	 * @return the user object if found, else return null
	 */
	public CustomUser findById(Long id);
	
	/**
	 * Find an user by username.
	 * 
	 * @param user the username
	 * @return the CustomUser object if found, else return null
	 */
	public CustomUser findByUserName(String username);
	
	/**
	 * Create new user.
	 * 
	 * @param CustomUser, the user to be created
	 * @return the created user 
	 */
	public CustomUser create(CustomUser user);
	
	/**
	 * Update an existing user's information.
	 * 
	 * @param CustomUser the updated user's record
	 * @return the updated user account
	 */
	public CustomUser update(CustomUser user);
	
	/**
	 * Delete a user from the system.
	 * 
	 * @param id user's id
	 */
	public void delete(Long id);
	
}
