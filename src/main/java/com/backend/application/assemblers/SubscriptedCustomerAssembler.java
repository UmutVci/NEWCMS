package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.SubscriptedCustomerController;
import com.backend.adapters.in.rest.dto.SubscriptedCustomerDTO;

public class SubscriptedCustomerAssembler extends BaseAssembler<SubscriptedCustomerDTO, Long, SubscriptedCustomerController>{
    public SubscriptedCustomerAssembler(Class<SubscriptedCustomerController> controllerClass) {
        super(controllerClass);
    }
}
