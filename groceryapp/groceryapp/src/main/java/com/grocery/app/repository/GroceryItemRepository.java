package com.grocery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.app.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{

}
