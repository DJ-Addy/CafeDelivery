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
import org.springframework.web.bind.annotation.RestController;

import com.ADcodes.CafeDelivery.model.Orders;
import com.ADcodes.CafeDelivery.model.Payment;
import com.ADcodes.CafeDelivery.repo.PaymentRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class PaymentController {

     @Autowired
    private PaymentRepo paymentRepo;

    // Add a new payment
    @PostMapping("/payment")
    public Payment addPayment(@RequestBody Payment newPayment) {
        return paymentRepo.save(newPayment);
    }

    // Update an existing payment
    @PutMapping("/payment/{paymentId}")
    public Payment updatePayment(@RequestBody Payment updatedPayment, @PathVariable Integer paymentId) {
        return paymentRepo.findById(paymentId)
                .map(payment -> {
                    payment.setPaymentAmount(updatedPayment.getPaymentAmount());
                    payment.setPaymentMethod(updatedPayment.getPaymentMethod());
                    payment.setPaymentTs(updatedPayment.getPaymentTs());
                    payment.setPaymentStatus(updatedPayment.getPaymentStatus());
                    payment.setOrder(updatedPayment.getOrder());
                    return paymentRepo.save(payment);
                })
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
    }

    // View a payment by ID
    @GetMapping("/payment/{paymentId}")
    public Payment viewPayment(@PathVariable Integer paymentId) {
        return paymentRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + paymentId));
    }

    // View all payments for an order
    @GetMapping("/order/{orderId}/payments")
    public List<Payment> viewPaymentsByOrder(@PathVariable Orders order) {
        return paymentRepo.findByOrder(order);
    }

    // Remove a payment by ID
    @DeleteMapping("/payment/{paymentId}")
    public void removePayment(@PathVariable Integer paymentId) {
        paymentRepo.deleteById(paymentId);
    }

    // View all payments (optional, for admin use)
    @GetMapping("/payments")
    public List<Payment> viewAllPayments() {
        return paymentRepo.findAll();
    }
}
