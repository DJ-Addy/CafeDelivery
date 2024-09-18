package com.ADcodes.CafeDelivery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ADcodes.CafeDelivery.exception.CustomerNotFound;
import com.ADcodes.CafeDelivery.model.Customer;
import com.ADcodes.CafeDelivery.repo.CustomerRepo;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {


    @Autowired
    public CustomerRepo customerRepo;

    @PostMapping("/customer")

    Customer newCustomer(@RequestBody Customer newCustomer ){

        return customerRepo.save(newCustomer);
    }

    @GetMapping("/customer")
    List<Customer> getallCustomers(){
        
        return customerRepo.findAll();
    }

    //get customer based on id
    @GetMapping("/customer/{id}")
    Customer getCustById(@PathVariable Integer id) {
        return customerRepo.findById(id)
        .orElseThrow(() -> new CustomerNotFound(id));
    }

    //TODO: need Put Mapping to change existing user info 

    @PutMapping("/customer/{id}")
    Customer updateUser(@RequestBody Customer newCust, @PathVariable Integer id) {
        return customerRepo.findById(id)
        .map(customer -> {
            customer.setCustFirstName(newCust.getCustFirstName());
            customer.setCustLastName(newCust.getCustLastName());
            customer.setCustEmail(newCust.getCustEmail());
            customer.setCustPhoneNum(newCust.getCustPhoneNum());
            return customerRepo.save(customer); // Save updated customer
        })
        .orElseThrow(() -> new CustomerNotFound(id));
    }


}
