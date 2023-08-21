package com.example.week05d1.Repository;

import com.example.week05d1.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    Merchant findMerchantById(Integer id);

}
