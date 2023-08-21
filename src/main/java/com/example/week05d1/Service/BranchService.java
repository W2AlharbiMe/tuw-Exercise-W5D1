package com.example.week05d1.Service;

import com.example.week05d1.Api.ApiException;
import com.example.week05d1.Model.Branch;
import com.example.week05d1.Model.Branch;
import com.example.week05d1.Model.Merchant;
import com.example.week05d1.Repository.BranchRepository;
import com.example.week05d1.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final MerchantRepository merchantRepository;



    public List<Branch> findAll() {
        return branchRepository.findAll();
    }


    public Branch findById(Integer id) {
        Branch branch = branchRepository.findBranchById(id);


        if(branch == null) {
            throw new ApiException("branch not found");
        }



        return branch;
    }

    public LinkedHashMap<String, Object> add(Branch branch) {

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "saved");
        res.put("branch", branchRepository.save(branch));

        return res;
    }


    public LinkedHashMap<String, Object> update(Integer id, Branch branch) {
        Branch branch1 = branchRepository.findBranchById(id);


        if(branch1 == null) {
            throw new ApiException("branch not found");
        }

        branch1.setArea(branch.getArea());
        branch1.setNumber(branch.getNumber());

        branchRepository.save(branch1);

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "updated");
        res.put("branch", branch1);

        return res;
    }


    public LinkedHashMap<String, Object> delete(Integer id) {
        Branch branch1 = branchRepository.findBranchById(id);


        if(branch1 == null) {
            throw new ApiException("branch not found");
        }

        branchRepository.deleteById(id);


        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "deleted");
        res.put("branch", branch1);

        return res;
    }


    public LinkedHashMap<String, Object> assignMerchantToBranch(Integer merchantId, Integer branchId) {
        Merchant merchant = merchantRepository.findMerchantById(merchantId);

        if (merchant == null) {
            throw new ApiException("merchant not found");
        }

        Branch branch = branchRepository.findBranchById(branchId);

        if(branch == null) {
            throw new ApiException("branch not found");
        }

        branch.setMerchant(merchant);

        branchRepository.save(branch);

        LinkedHashMap<String, Object> res = new LinkedHashMap<>();

        res.put("message", "assigned");
        res.put("merchant", merchant);
        return res;
    }
}
