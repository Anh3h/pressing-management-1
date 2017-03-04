package com.tragent.pressing.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

import com.tragent.pressing.model.PaymentMethod;
import com.tragent.pressing.service.PaymentMethodService;

@RestController
@RequestMapping("api/v1/paymentmethods")
public class PaymentMethodController {

	@Autowired
	PaymentMethodService paymentMethodService;
	
	/**
	 * Get all payment method or payment method with the given name.
	 * 
	 * @return all payment method transaction in the system or payment method with the given name
	 */
	@RequestMapping(method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<PaymentMethod>> getPaymentMethods(@RequestParam(value = "name", required = false) String name) {
		
		Collection<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
		if (name != null) {
			PaymentMethod paymentMethod = paymentMethodService.findByName(name);
			paymentMethods.add(paymentMethod);
		} else {
			Collection<PaymentMethod> allPaymentMethod = paymentMethodService.findAll();
			paymentMethods.addAll(allPaymentMethod);
		}
		return new ResponseEntity<Collection<PaymentMethod>>(paymentMethods, HttpStatus.OK);
		
	}
	
	/**
	 * Get payment method with a given id.
	 * 
	 * @param methodId
	 * @return the payment method with the given id or 404 if customer is not found
	 */
	@RequestMapping(value="/{methodId}",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable("methodId") Long methodId){
		
		PaymentMethod paymentMethod = paymentMethodService.findById(methodId);
		if (paymentMethod == null) {
			return new ResponseEntity<PaymentMethod>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
	}
	
	/**
	 * Create new payment method
	 * 
	 * @param payment method
	 * @return the created payment method and HttpStatus.CREATED if payment method was successfully created
	 */
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod method){
		
		method = paymentMethodService.create(method);
		if (method == null) {
			return new ResponseEntity<PaymentMethod>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<PaymentMethod>(method, HttpStatus.CREATED);
		
	}
	
	/**
	 * update payment method record
	 * 
	 * @param payment method
	 * @return the updated payment method.
	 */
	@RequestMapping(value="/{methodId}",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod method){
		
		method = paymentMethodService.update(method);
		if (method == null) {
			return new ResponseEntity<PaymentMethod>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PaymentMethod>(method, HttpStatus.OK);
		
	}
}
