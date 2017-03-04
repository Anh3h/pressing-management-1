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

import com.tragent.pressing.model.Customer;
import com.tragent.pressing.service.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	/**
	 * Get all customer or customer with a particular email .
	 * 
	 * @param customerEmail
	 * @return all customers or customer with a particular email in the system
	 */
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getCustomers(@RequestParam(value = "customerEmail", required = false) String customerEmail ){
		
		Collection<Customer> customers = new ArrayList<>();
		if (customerEmail!= null) {
			Customer customer = customerService.findByEmail(customerEmail);
			customers.add(customer);
		} else {
			Collection<Customer> allCategories = customerService.findAll();
			customers.addAll(allCategories);
		}
		return new ResponseEntity<Collection<Customer>>(customers, HttpStatus.OK);
		
	}
	
	/**
	 * Get customer with given customer id.
	 * 
	 * @param customerId
	 * @return the customer with the given id or 404 if customer is not found
	 */
	@RequestMapping(value="/{customerId}",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long customerId){
		
		Customer customer = customerService.findById(customerId);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	/**
	 * Create new customer
	 * 
	 * @param customer
	 * @return the created customer and HttpStatus.CREATED if customer was successfully created
	 */
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		
		customer = customerService.create(customer);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		
	}
	
	/**
	 * update customer
	 * 
	 * @param customer
	 * @return the updated customer.
	 */
	@RequestMapping(value="/{customerId}",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		
		customer = customerService.update(customer);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}

}
