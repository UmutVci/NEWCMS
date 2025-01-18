package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.CustomerController;
import com.backend.adapters.in.rest.dto.CustomerDTO;

public class CustomerAssembler extends BaseAssembler<CustomerDTO, Long, CustomerController>{
    public CustomerAssembler(Class<CustomerController> controllerClass) {
        super(controllerClass);
    }
}
