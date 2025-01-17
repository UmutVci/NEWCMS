package com.backend.application.services;

import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.domain.entities.CustomerEntity;
import com.backend.domain.entities.SubscriptedCustomer;
import com.backend.domain.repository.ICustomerRepository;
import com.backend.domain.repository.ISubscriptionCustomerRepository;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, Long> {

    @Autowired
    private final ICustomerRepository customerRepository;
    private final ISubscriptionCustomerRepository iSubscriptionCustomerRepository;


    public CustomerService(ICustomerRepository customerRepository, BaseMapper<CustomerEntity, CustomerDTO> mapper, ISubscriptionCustomerRepository iSubscriptionCustomerRepository) {
        super(customerRepository, mapper);
        this.customerRepository = customerRepository;
        this.iSubscriptionCustomerRepository = iSubscriptionCustomerRepository;
    }

     public boolean isSub(Long customerId){
        int count = iSubscriptionCustomerRepository.isSub(customerId);
         if(count == 0){
             return false;
         }
             return true;
     }



}
