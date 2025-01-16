package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.SubscriptedCustomerDTO;
import com.backend.application.services.BaseService;
import com.backend.domain.entities.SubscriptedCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscriptedcustomers")

public class SubscriptedCustomerController extends BaseController<SubscriptedCustomer, SubscriptedCustomerDTO , Long> {

    @Autowired
    public SubscriptedCustomerController(BaseService<SubscriptedCustomer, SubscriptedCustomerDTO, Long> service) {
        super(service);
    }

}
