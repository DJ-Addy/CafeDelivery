package com.ADcodes.CafeDelivery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ADcodes.CafeDelivery.model.OrderItems;
import com.ADcodes.CafeDelivery.repo.OrderItemRepo;

@RestController
@RequestMapping("/orderitems")
@CrossOrigin("http://localhost:3000")
public class OrderItemsController {
 @Autowired
    private OrderItemRepo orderItemsRepo;

    // Add a new item to the order
    @PostMapping
    public OrderItems addItemToOrder(@RequestBody OrderItems newOrderItem) {
        return orderItemsRepo.save(newOrderItem);
    }

    // Increase the quantity of an item in the order
    @PutMapping("/{id}/increase")
    public OrderItems increaseQuantityOfItem(@PathVariable Integer id) {
        return orderItemsRepo.findById(id)
                .map(orderItem -> {
                    orderItem.setQuantity(orderItem.getQuantity() + 1);
                    return orderItemsRepo.save(orderItem);
                })
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id " + id));
    }

    // Decrease the quantity of an item in the order
    @PutMapping("/{id}/decrease")
    public OrderItems reduceQuantityOfItem(@PathVariable Integer id) {
        return orderItemsRepo.findById(id)
                .map(orderItem -> {
                    if (orderItem.getQuantity() > 1) {
                        orderItem.setQuantity(orderItem.getQuantity() - 1);
                        return orderItemsRepo.save(orderItem);
                    } else {
                        throw new RuntimeException("Cannot reduce quantity below 1");
                    }
                })
                .orElseThrow(() -> new RuntimeException("OrderItem not found with id " + id));
    }

    // Remove an item from the order
    @DeleteMapping("/{id}")
    public void removeItemFromOrderItems(@PathVariable Integer id) {
        orderItemsRepo.deleteById(id);
    }

    // Clear all items from an order
    @DeleteMapping("/order/{orderId}/clear")
    public void clearOrderItems(@PathVariable Integer orderId) {
        orderItemsRepo.deleteByOrderOrderId(orderId);
    }

    // Get all items in a specific order
    @GetMapping("/order/{orderId}")
    public List<OrderItems> getOrderItemsByOrderId(@PathVariable Integer orderId) {
        return orderItemsRepo.findByOrderOrderId(orderId);
    }
}
