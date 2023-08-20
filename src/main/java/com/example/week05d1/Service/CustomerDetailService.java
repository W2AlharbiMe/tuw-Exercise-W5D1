package com.example.week05d1.Service;

import com.example.week05d1.Api.ApiException;
import com.example.week05d1.DTO.DetailsDTO;
import com.example.week05d1.Model.Customer;
import com.example.week05d1.Model.CustomerDetail;
import com.example.week05d1.Repository.CustomerDetailRepository;
import com.example.week05d1.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailService {

    private final CustomerRepository customerRepository;
    private final CustomerDetailRepository customerDetailRepository;


    public List<CustomerDetail> findAll() {
        return customerDetailRepository.findAll();
    }

    public CustomerDetail addDetail(DetailsDTO detailsDTO) {
        Customer customer = customerRepository.findCustomerById(detailsDTO.getCustomerId());

        if(customer == null) {
            throw new ApiException("customer not found.");
        }

        CustomerDetail customerDetail = new CustomerDetail(null, customer, detailsDTO.getGender(), detailsDTO.getEmail(), detailsDTO.getAge());

        return customerDetailRepository.save(customerDetail);
    }

    public CustomerDetail updateDetail(Integer id, DetailsDTO detailsDTO) {
        CustomerDetail customerDetail1 = customerDetailRepository.findCustomerDetailById(id);

        if(customerDetail1 == null) {
            throw new ApiException("Not found.");
        }

        customerDetail1.setAge(detailsDTO.getAge());
        customerDetail1.setEmail(detailsDTO.getEmail());
        customerDetail1.setGender(detailsDTO.getGender());


        customerDetailRepository.save(customerDetail1);

        return customerDetail1;
    }

    public CustomerDetail delete(Integer id) {
        CustomerDetail customerDetail1 = customerDetailRepository.findCustomerDetailById(id);

        if(customerDetail1 == null) {
            throw new ApiException("Not found.");
        }

        customerDetailRepository.deleteById(id);

        return customerDetail1;
    }

}
