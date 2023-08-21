package com.example.week05d1.Controller;

import com.example.week05d1.Model.Merchant;
import com.example.week05d1.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/merchants")
@RequiredArgsConstructor
public class MerchantsController {

    private final MerchantService merchantService;

    public ResponseEntity<List<Merchant>> findAll() {
        return ResponseEntity.ok(merchantService.findAll());
    }


    public ResponseEntity<Merchant> findById(Integer id) {
        return ResponseEntity.ok(merchantService.findById(id));
    }


    public ResponseEntity<LinkedHashMap<String, Object>> add(@RequestBody @Valid Merchant merchant) {
        return ResponseEntity.ok(merchantService.add(merchant));
    }

    public ResponseEntity<LinkedHashMap<String, Object>> update(@PathVariable Integer id, @RequestBody @Valid Merchant merchant) {
        return ResponseEntity.ok(merchantService.update(id, merchant));
    }

    public ResponseEntity<LinkedHashMap<String, Object>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(merchantService.delete(id));
    }

}
