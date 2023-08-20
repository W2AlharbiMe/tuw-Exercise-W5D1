package com.example.week05d1.Repository;

import com.example.week05d1.Model.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Integer> {

    CustomerDetail findCustomerDetailById(Integer id);

}
