package com.example.week05d1.Controller;

import com.example.week05d1.DTO.DetailsDTO;
import com.example.week05d1.Model.CustomerDetail;
import com.example.week05d1.Repository.CustomerDetailRepository;
import com.example.week05d1.Service.CustomerDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers-details")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailService customerDetailService;

    @GetMapping("/get")
    public ResponseEntity<List<CustomerDetail>> findAll() {
        return ResponseEntity.ok(customerDetailService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDetail> add(@RequestBody @Valid DetailsDTO customerDetailsDTO) {
        return ResponseEntity.ok(customerDetailService.addDetail(customerDetailsDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDetail> update(@PathVariable Integer id, @RequestBody @Valid DetailsDTO customerDetailsDTO) {
        return ResponseEntity.ok(customerDetailService.updateDetail(id, customerDetailsDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDetail> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(customerDetailService.delete(id));
    }
}
