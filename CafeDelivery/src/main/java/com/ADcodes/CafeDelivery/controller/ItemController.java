package com.ADcodes.CafeDelivery.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ADcodes.CafeDelivery.model.Items;
import com.ADcodes.CafeDelivery.repo.ItemRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemRepo itemRepo;

    // Add new item
   @PostMapping("/items")
    public ResponseEntity<Items> addItem(@RequestBody Items newItem) {
        try {
            Items savedItem = itemRepo.save(newItem);
            return ResponseEntity.ok(savedItem);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Update existing item
    @PutMapping("/items/{id}")
    public Items updateItem(@RequestBody Items updatedItem, @PathVariable Integer id) {
        return itemRepo.findById(id)
                .map(item -> {
                    item.setItemName(updatedItem.getItemName());
                    item.setItemCat(updatedItem.getItemCat());
                    item.setItemSize(updatedItem.getItemSize());
                    item.setItemPrice(updatedItem.getItemPrice());
                    item.setItemDescription(updatedItem.getItemDescription());
                    item.setItemImageUrl(updatedItem.getItemImageUrl());
                    return itemRepo.save(item);
                })
                .orElseGet(() -> {
                    updatedItem.setItemId(id);
                    return itemRepo.save(updatedItem);
                });
    }

    // View all items
    @GetMapping("/items")
    public List<Items> getAllItems() {
        return itemRepo.findAll();
    }

    // Get item by id
    @GetMapping("/items/{id}")
    public Optional<Items> getItemById(@PathVariable Integer id) {
        return itemRepo.findById(id);
    }

    // Remove item by id
    @DeleteMapping("/items/{id}")
    public void removeItem(@PathVariable Integer id) {
        itemRepo.deleteById(id);
    }

    // Get items by name
    @GetMapping("/items/name/{itemName}")
    public List<Items> getItemsByName(@PathVariable String itemName) {
        return itemRepo.findByItemName(itemName);
    }

    // Get items by category
    @GetMapping("/items/category/{itemCat}")
    public List<Items> getItemsByCategory(@PathVariable String itemCate) {
        return itemRepo.findByItemCate(itemCate);
    }

}
