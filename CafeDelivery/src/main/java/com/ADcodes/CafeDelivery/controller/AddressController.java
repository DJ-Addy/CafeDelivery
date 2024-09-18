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

import com.ADcodes.CafeDelivery.model.Address;
import com.ADcodes.CafeDelivery.repo.AddressRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    // Create new address
    @PostMapping("/address")
    public Address createAddress(@RequestBody Address address) {
        return addressRepo.save(address);
    }

    // Get all addresses
    @GetMapping("/address")
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    // Get an address by ID
    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return addressRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    }

    // Update an existing address
    @PutMapping("/address/{id}")
    public Address updateAddress(@RequestBody Address updatedAddress, @PathVariable Integer id) {
        return addressRepo.findById(id)
                .map(address -> {
                    address.setAddr1(updatedAddress.getAddr1());
                    address.setAddr2(updatedAddress.getAddr2());
                    address.setAddrCity(updatedAddress.getAddrCity());
                    address.setAddrState(updatedAddress.getAddrState());
                    address.setAddrZipcode(updatedAddress.getAddrZipcode());
                    return addressRepo.save(address);
                })
                .orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    }

    // Delete an address
    @DeleteMapping("/address/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        addressRepo.deleteById(id);
        return "Address with id " + id + " has been deleted!";
    }
}
