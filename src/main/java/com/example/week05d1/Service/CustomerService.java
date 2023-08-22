package com.example.week05d1.Service;

import com.example.week05d1.Api.ApiException;
import com.example.week05d1.Model.Customer;
import com.example.week05d1.Model.Merchant;
import com.example.week05d1.Repository.CustomerDetailRepository;
import com.example.week05d1.Repository.CustomerRepository;
import com.example.week05d1.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDetailRepository customerDetailRepository;
    private final MerchantRepository merchantRepository;


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer updateCustomer(Integer id, Customer customer) {
        Customer customer1 = customerRepository.findCustomerById(id);

        if(customer1 == null) {
            throw new ApiException("Customer not found.");
        }

        customer1.setName(customer.getName());

        customerRepository.save(customer1);

        return customer1;
    }

    public Customer delete(Integer id) {
        Customer customer1 = customerRepository.findCustomerById(id);

        if(customer1 == null) {
            throw new ApiException("Customer not found.");
        }

        if(customer1.getCustomerDetail() != null) {
            customerDetailRepository.deleteById(customer1.getCustomerDetail().getId());
        }

        customerRepository.deleteById(id);

        return customer1;
    }

    public Customer assignCustomerToMerchant(Integer customerId, Integer merchantId) {
        Customer customer1 = customerRepository.findCustomerById(customerId);

        if(customer1 == null) {
            throw new ApiException("Customer not found.");
        }

        Merchant merchant = merchantRepository.findMerchantById(merchantId);

        if(merchant == null) {
            throw new ApiException("Merchant not found.");
        }

        customer1.getMerchants().add(merchant);
        merchant.getCustomers().add(customer1);

        customerRepository.save(customer1);
        merchantRepository.save(merchant);


        return customer1;
    }
}
