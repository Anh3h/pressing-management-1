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

import com.tragent.pressing.model.Category;
import com.tragent.pressing.model.CleaningMaterial;
import com.tragent.pressing.model.Item;
import com.tragent.pressing.service.CategoryService;
import com.tragent.pressing.service.CleaningMaterialService;
import com.tragent.pressing.service.ItemService;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CleaningMaterialService cleaningMaterialService;
	
	/**
	 * Get all categories or category with a particular name .
	 * 
	 * @param categoryName
	 * @return all categories or category with a particular name in the system
	 */
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Category>> getCategories(@RequestParam(value = "categoryName", required = false) String categoryName){
		
		Collection<Category> categories = new ArrayList<>();
		if (categoryName != null) {
			Category category = categoryService.findByName(categoryName);
			categories.add(category);
		} else {
			Collection<Category> allCategories = categoryService.findAll();
			categories.addAll(allCategories);
		}
		return new ResponseEntity<Collection<Category>>(categories, HttpStatus.OK);
		
	}
	
	/**
	 * Get Category with given category id.
	 * 
	 * @param categoryId
	 * @return the category with the given id or 404 if category is not found
	 */
	@RequestMapping(value="/{categoryId}",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId") Long categoryId){
		
		Category category = categoryService.findById(categoryId);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	/**
	 * Get items with same category.
	 * 
	 * @param categoryId
	 * @return collection of categories if found
	 */
	@RequestMapping(value="/{categoryId}/items",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Item>> getCategoryItem(@PathVariable("categoryId") Long categoryId){
		
		Collection<Item> items = itemService.findCategoryItems(categoryId);		
		return new ResponseEntity<Collection<Item>>(items, HttpStatus.OK);
	}
	
	/**
	 * Get cleaning materials with same category.
	 * 
	 * @param materialId
	 * @return collection of cleaning materials if found
	 */
	@RequestMapping(value="/{categoryId}/cleaningmaterials",
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CleaningMaterial>> getCategoryMaterial(@PathVariable("categoryId") Long categoryId){
		
		Collection<CleaningMaterial> materials = cleaningMaterialService.findByCategory(categoryId);	
		return new ResponseEntity<Collection<CleaningMaterial>>(materials, HttpStatus.OK);
	}
	
	/**
	 * Create new category
	 * 
	 * @param category
	 * @return the created category and HttpStatus.CREATED if category was successfully created
	 */
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		
		category = categoryService.create(category);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
		
	}
	
	/**
	 * update category
	 * 
	 * @param category
	 * @return the updated category.
	 */
	@RequestMapping(value="/{categoryId}",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		
		category = categoryService.update(category);
		if (category == null) {
			return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Category>(category, HttpStatus.OK);
		
	}
	
}
