package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.application.services.BaseService;
import com.backend.application.services.CustomerService;
import com.backend.domain.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/customers")
public class CustomerController extends BaseController<CustomerEntity, CustomerDTO, Long>{

    private final CustomerService customerService;
    public CustomerController(BaseService<CustomerEntity, CustomerDTO, Long> service, CustomerService customerService) {
        super(service);
        this.customerService = customerService;
    }

    @GetMapping("/{id}/issub")
    public ResponseEntity<Boolean> isSub(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.isSub(id));
    }

    @Override
    public Class<? extends BaseController<CustomerEntity, CustomerDTO, Long>> getControllerClass() {
        return CustomerController.class;
    }

}
