package com.ADcodes.CafeDelivery.controller;

import java.util.*;
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

import com.ADcodes.CafeDelivery.model.Customer;
import com.ADcodes.CafeDelivery.model.Orders;
import com.ADcodes.CafeDelivery.repo.OrderRepo;

@RestController
@RequestMapping("/order")
@CrossOrigin("http://localhost:3000")
public class OrderController {
     @Autowired
    private OrderRepo ordersRepo;

    // Add a new order
    @PostMapping
    public Orders addOrder(@RequestBody Orders newOrder) {
        return ordersRepo.save(newOrder);
    }

    // Remove an order by ID
    @DeleteMapping("/{orderId}")
    public void removeOrder(@PathVariable Integer orderId) {
        ordersRepo.deleteById(orderId);
    }

    // Update an order by ID
    @PutMapping("/{orderId}")
    public Orders updateOrder(@RequestBody Orders updatedOrder, @PathVariable Integer orderId) {
        return ordersRepo.findById(orderId)
                .map(order -> {
                    order.setOrderTs(updatedOrder.getOrderTs());
                    order.setCustomer(updatedOrder.getCustomer());
                    order.setAddress(updatedOrder.getAddress());
                    order.setTotalPrice(updatedOrder.getTotalPrice());
                    order.setDeliveryType(updatedOrder.getDeliveryType());
                    order.setPaymentStatus(updatedOrder.getPaymentStatus());
                    order.setPaymentIntentId(updatedOrder.getPaymentIntentId());
                    return ordersRepo.save(order);
                })
                .orElseGet(() -> {
                    updatedOrder.setOrderId(orderId);
                    return ordersRepo.save(updatedOrder);
                });
    }

    // View an order by ID
    @GetMapping("/{orderId}")
    public Orders viewOrder(@PathVariable Integer orderId) {
        return ordersRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    // View all orders in the cafe (for admin)
    @GetMapping
    public List<Orders> viewAllOrdersInCafe() {
        return ordersRepo.findAll();
    }

    // View all orders for a customer
    @GetMapping("/customer/{customerId}/orders")
    public List<Orders> viewAllOrdersCustomer(@PathVariable Customer customer) {
        return ordersRepo.findByCustomer(customer);
    }

}
