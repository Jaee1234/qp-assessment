package com.grocery.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.app.entity.GroceryItem;
import com.grocery.app.serviceImpl.GroceryItemService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private GroceryItemService itemService;

    @GetMapping("/items")
    public List<GroceryItem> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/items")
    public GroceryItem addItem(@RequestBody GroceryItem item) {
        return itemService.addItem(item);
    }

    @PutMapping("/items/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
	
}
