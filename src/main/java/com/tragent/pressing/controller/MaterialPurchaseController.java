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

import com.tragent.pressing.model.MaterialPurchase;
import com.tragent.pressing.service.MaterialPurchaseService;

@RestController
@RequestMapping("api/v1/expenditures")
public class MaterialPurchaseController {
	
	@Autowired
	private MaterialPurchaseService materialPurchaseService;
	
	/**
	 * Get all expenditures made or expenditures made on a particular day.
	 * 
	 * @param purchase date
	 * @return all expenditures or expenditures made on a particular day.
	 * @throws ParseException 
	 */
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<MaterialPurchase>> getExpenditures(@RequestParam(value = "purchaseDate", required = false) String purchaseDate ) throws ParseException{
		
		Collection<MaterialPurchase> materialPurchases = new ArrayList<>();
		
		if (purchaseDate != null) {
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			Date date = formatter.parse(purchaseDate);
			Collection<MaterialPurchase> materialPurchase = materialPurchaseService.findByPurchasDate(date);
			materialPurchases.addAll(materialPurchase);
			
		} else {
			Collection<MaterialPurchase> allMaterialPurchases = materialPurchaseService.findAll();
			materialPurchases.addAll(allMaterialPurchases);
		}
		return new ResponseEntity<Collection<MaterialPurchase>>(materialPurchases, HttpStatus.OK);
		
	}
	
	/**
	 * Get expenditure with a given id.
	 * 
	 * @param purchaseId
	 * @return the expenditure with the given id or 404 if customer is not found
	 */
	@RequestMapping(value="/{purchaseId}",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialPurchase> getExpenditureById(@PathVariable("purchaseId") Long purchaseId){
		
		MaterialPurchase materialPurchase = materialPurchaseService.findById(purchaseId);
		if (materialPurchase == null) {
			return new ResponseEntity<MaterialPurchase>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<MaterialPurchase>(materialPurchase, HttpStatus.OK);
	}
	
	/**
	 * Create new expenditure record
	 * 
	 * @param expenditure
	 * @return the created expenditure and HttpStatus.CREATED if customer was successfully created
	 */
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialPurchase> createExpenditure(@RequestBody MaterialPurchase purchase){
		
		purchase = materialPurchaseService.create(purchase);
		if (purchase == null) {
			return new ResponseEntity<MaterialPurchase>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<MaterialPurchase>(purchase, HttpStatus.CREATED);
		
	}
	
	/**
	 * update expenditure record
	 * 
	 * @param expenditure
	 * @return the updated record.
	 */
	@RequestMapping(value="/{customerId}",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialPurchase> updateExpenditure(@RequestBody MaterialPurchase purchase){
		
		purchase = materialPurchaseService.update(purchase);
		if (purchase == null) {
			return new ResponseEntity<MaterialPurchase>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<MaterialPurchase>(purchase, HttpStatus.OK);
		
	}

}
