package com.grocery.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.app.entity.GroceryItem;
import com.grocery.app.serviceImpl.GroceryItemService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private GroceryItemService itemService;

    @GetMapping("/items")
    public List<GroceryItem> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/book/{id}")
    public void bookItem(@PathVariable Long id, @RequestParam int quantity) {
        itemService.updateInventory(id, quantity);
    }
}
