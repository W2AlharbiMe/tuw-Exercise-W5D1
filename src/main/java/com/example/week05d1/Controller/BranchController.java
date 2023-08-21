package com.example.week05d1.Controller;

import com.example.week05d1.Model.Branch;
import com.example.week05d1.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/get")
    public ResponseEntity<List<Branch>> findAll() {
        return ResponseEntity.ok(branchService.findAll());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Branch> findById(Integer id) {
        return ResponseEntity.ok(branchService.findById(id));
    }


    @PostMapping("/add")
    public ResponseEntity<LinkedHashMap<String, Object>> add(@RequestBody @Valid Branch branch) {
        return ResponseEntity.ok(branchService.add(branch));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> update(@PathVariable Integer id, @RequestBody Branch merchant) {
        return ResponseEntity.ok(branchService.update(id, merchant));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LinkedHashMap<String, Object>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(branchService.delete(id));
    }

    @PutMapping("/assign/{merchantId}/{branchId}")
    public ResponseEntity<LinkedHashMap<String, Object>> assign(@PathVariable Integer merchantId, @PathVariable Integer branchId) {
        return ResponseEntity.ok(branchService.assignMerchantToBranch(merchantId, branchId));
    }
}
