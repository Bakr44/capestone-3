package com.example.hotels_api.Service;

import com.example.hotels_api.Api.ApiException;
import com.example.hotels_api.Model.Customer;
import com.example.hotels_api.Model.Hotels;
import com.example.hotels_api.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id,Customer customer){
            Customer customer1=customerRepository.findCustomerById(id);
            if (customer1==null){
                throw new ApiException("Customer with ID " + id + " not found");
            }
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        customer1.setIdNationality(customer.getIdNationality());
            customerRepository.save(customer1);
        }

    public void deleteCustomer(Integer id){
        Customer customer1= customerRepository.findCustomerById(id);
        if (customer1==null){
            throw new ApiException("Customer with ID " + id + " not found");
        }
        customerRepository.deleteById(id);
    }
}
