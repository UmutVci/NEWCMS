package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.domain.entities.CustomerEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CustomerMapper implements BaseMapper<CustomerEntity, CustomerDTO> {

    @Override
    public CustomerDTO toDto(CustomerEntity entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setName(entity.getName());
        return customerDTO;
    }

    @Override
    public CustomerEntity toEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
