package com.backend.application.services;

import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.domain.entities.CustomerEntity;
import com.backend.domain.entities.SubscriptedCustomer;
import com.backend.domain.repository.ICustomerRepository;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, Long> {

    @Autowired
    private final ICustomerRepository customerRepository;


    public CustomerService(ICustomerRepository customerRepository, BaseMapper<CustomerEntity, CustomerDTO> mapper) {
        super(customerRepository, mapper);
        this.customerRepository = customerRepository;
    }

    public CustomerEntity createCustomer(String name, int age) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setAge(age);
        return customerRepository.save(customer);
    }

     public boolean isSub(Long customerId){
        CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(()->
                new ResourceNotFoundException("Customer not found with ID: " + customerId ));
         return customer instanceof SubscriptedCustomer;
     }



}
