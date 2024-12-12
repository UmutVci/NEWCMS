package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.domain.entities.CustomerEntity;
import org.springframework.stereotype.Component;

@Component

public class CustomerMapper implements BaseMapper<CustomerEntity, CustomerDTO> {

    @Override
    public CustomerDTO toDto(CustomerEntity entity) {
        return new CustomerDTO(entity.getName());
    }

    @Override
    public CustomerEntity toEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
