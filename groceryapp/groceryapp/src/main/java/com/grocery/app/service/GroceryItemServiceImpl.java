package com.grocery.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.app.entity.GroceryItem;
import com.grocery.app.repository.GroceryItemRepository;
import com.grocery.app.serviceImpl.GroceryItemService;

@Service
public class GroceryItemServiceImpl implements GroceryItemService{
	@Autowired
    private GroceryItemRepository itemRepository;

    @Override
    public List<GroceryItem> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public GroceryItem addItem(GroceryItem item) {
        return itemRepository.save(item);
    }

    @Override
    public GroceryItem updateItem(Long id, GroceryItem item) {
        Optional<GroceryItem> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            GroceryItem newItem = existingItem.get();
            newItem.setName(item.getName());
            newItem.setPrice(item.getPrice());
            newItem.setQuantity(item.getQuantity());
            return itemRepository.save(newItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void updateInventory(Long id, int quantity) {
        Optional<GroceryItem> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            GroceryItem item = existingItem.get();
            item.setQuantity(quantity);
            itemRepository.save(item);
        }
    }
}
