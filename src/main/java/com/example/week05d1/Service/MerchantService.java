package com.example.week05d1.Service;

import com.example.week05d1.Api.ApiException;
import com.example.week05d1.Model.Merchant;
import com.example.week05d1.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;


    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }


    public Merchant findById(Integer id) {
        Merchant merchant = merchantRepository.findMerchantById(id);


        if(merchant == null) {
            throw new ApiException("Merchant not found");
        }



        return merchant;
    }

    public LinkedHashMap<String, Object> add(Merchant merchant) {

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "saved");
        res.put("merchant", merchantRepository.save(merchant));

        return res;
    }


    public LinkedHashMap<String, Object> update(Integer id, Merchant merchant) {
        Merchant merchant1 = merchantRepository.findMerchantById(id);


        if(merchant1 == null) {
            throw new ApiException("Merchant not found");
        }

        merchant1.setName(merchant.getName());

        merchantRepository.save(merchant1);

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "updated");
        res.put("merchant", merchant1);

        return res;
    }


    public LinkedHashMap<String, Object> delete(Integer id) {

        Merchant merchant1 = merchantRepository.findMerchantById(id);


        if(merchant1 == null) {
            throw new ApiException("Merchant not found");
        }

        merchantRepository.deleteById(id);


        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "deleted");
        res.put("merchant", merchant1);

        return res;
    }
}
