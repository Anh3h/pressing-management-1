package com.tragent.pressing.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tragent.pressing.model.Item;
import com.tragent.pressing.repository.ItemRepository;
import com.tragent.pressing.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Collection<Item> findAll() {
		
		Collection<Item> items = itemRepository.findAll();
		return items;
		
	}

	@Override
	public Item findById(Long id) {
		
		Item item = itemRepository.findOne(id);
		return item;
		
	}

	@Override
	public Item findByName(String name) {
		
		Item item = itemRepository.findByName(name);
		return item;
		
	}

	@Override
	public Item create(Item item) {
		
		if (itemRepository.exists(item.getId())) {
			return null;
		}
		
		Item savedItem = itemRepository.save(item);
		return savedItem;
		
	}

	@Override
	public Item update(Item item) {

		if (itemRepository.exists(item.getId())) {
			return null;
		}
		
		Item savedItem = itemRepository.save(item);
		return savedItem;
		
	}

	@Override
	public void delete(Long id) {
		
		Item item = findById(id);
		if (item == null) {
			return;
		}
		
		itemRepository.delete(item);
		
	}

}
