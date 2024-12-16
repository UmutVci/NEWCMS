package com.backend.application.services;

import com.backend.adapters.in.rest.dto.SubscriptedCustomerDTO;
import com.backend.adapters.in.rest.mapper.SubscriptedCustomerMapper;
import com.backend.domain.entities.SubscriptedCustomer;
import com.backend.domain.repository.ISubscriptionCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptedCustomerService extends BaseService<SubscriptedCustomer , SubscriptedCustomerDTO , Long> {

    @Autowired
    private SubscriptedCustomerMapper mapper;
    @Autowired
    private ISubscriptionCustomerRepository repository;


    public SubscriptedCustomerService(ISubscriptionCustomerRepository repository, SubscriptedCustomerMapper mapper) {
        super(repository, mapper);
    }

    public SubscriptedCustomerDTO createSubscribedCustomer(SubscriptedCustomerDTO subscriptedCustomerDTO) {
        SubscriptedCustomer sCustomer = mapper.toEntity(subscriptedCustomerDTO);
        SubscriptedCustomer savedEntity = repository.save(sCustomer);
        return mapper.toDto(savedEntity);
    }


}
