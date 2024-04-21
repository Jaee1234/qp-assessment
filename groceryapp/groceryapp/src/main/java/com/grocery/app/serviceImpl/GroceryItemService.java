package com.grocery.app.serviceImpl;

import java.util.List;

import com.grocery.app.entity.GroceryItem;

public interface GroceryItemService {

	List<GroceryItem> getAllItems();
    GroceryItem addItem(GroceryItem item);
    GroceryItem updateItem(Long id, GroceryItem item);
    void deleteItem(Long id);
    void updateInventory(Long id, int quantity);
	
}
