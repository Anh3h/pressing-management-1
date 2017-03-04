package com.tragent.pressing.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tragent.pressing.model.CustomUser;
import com.tragent.pressing.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Get all uses or user with a particular username .
	 * 
	 * @param username
	 * @return all users or user with a particular username  in the system
	 */
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CustomUser>> getUsers(@RequestParam(value = "username", required = false) String username){
		
		Collection<CustomUser> users = new ArrayList<CustomUser>();
		if (username != null) {
			CustomUser user = userService.findByUserName(username);
			users.add(user);
		} else {
			Collection<CustomUser> allUser = userService.findAll();
			users.addAll(allUser);
		}
		return new ResponseEntity<Collection<CustomUser>>(users, HttpStatus.OK);
		
	}
	
	/**
	 * Get user with given user id.
	 * 
	 * @param userId
	 * @return the user with given id or 404 if id is not found
	 */
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomUser> getUserById(@PathVariable("id") Long userId){
		
		CustomUser user = userService.findById(userId);
		if (user == null) {
			return new ResponseEntity<CustomUser>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CustomUser>(user, HttpStatus.OK);
	}
	
	/**
	 * Create new user
	 * 
	 * @param user
	 * @return the created user and HttpStatus.CREATED if user was successfully created
	 */
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomUser> createUser(@RequestBody CustomUser user){
		
		user = userService.create(user);
		if (user == null) {
			return new ResponseEntity<CustomUser>(HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<CustomUser>(user, HttpStatus.CREATED);
		
	}
	
	/**
	 * update user's information
	 * 
	 * @param userId
	 * @return the updated user information.
	 */
	@RequestMapping(value="/{userId}",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomUser> updateUser(@RequestBody CustomUser user){
		
		user = userService.update(user);
		if (user == null) {
			return new ResponseEntity<CustomUser>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<CustomUser>(user, HttpStatus.OK);
		
	}
	
	/**
	 * Delete user's information
	 * 
	 * @param id, id of the user
	 * @return 204, .
	 */
	@RequestMapping(value="/{id}",
			method=RequestMethod.DELETE)
	public ResponseEntity<CustomUser> deleteUser(@PathVariable("id") Long id){
		
		userService.delete(id);
		return new ResponseEntity<CustomUser>(HttpStatus.NO_CONTENT);
		
	}
}
