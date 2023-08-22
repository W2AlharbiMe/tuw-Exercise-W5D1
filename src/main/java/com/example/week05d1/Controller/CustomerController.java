package com.example.week05d1.Controller;

import com.example.week05d1.Model.Customer;
import com.example.week05d1.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> addCustomer(@PathVariable Integer id, @RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.delete(id));
    }

    @PutMapping("/assign/customer-to-merchant/{customerId}/{merchantId}")
    public ResponseEntity<Customer> assignCustomerToMerchant(@PathVariable Integer customerId, @PathVariable Integer merchantId) {
        return ResponseEntity.ok(customerService.assignCustomerToMerchant(customerId, merchantId));
    }


}
