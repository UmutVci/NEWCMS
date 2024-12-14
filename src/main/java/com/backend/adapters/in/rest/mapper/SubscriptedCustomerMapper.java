package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.SessionDTO;
import com.backend.adapters.in.rest.dto.SubscriptedCustomerDTO;
import com.backend.domain.entities.SessionEntity;
import com.backend.domain.entities.SubscriptedCustomer;
import org.springframework.stereotype.Component;

@Component
public class SubscriptedCustomerMapper implements BaseMapper<SubscriptedCustomer, SubscriptedCustomerDTO> {


    @Override
    public SubscriptedCustomerDTO toDto(SubscriptedCustomer subscriptedCustomerEntity) {
        if (subscriptedCustomerEntity == null) {
            return null;
        } else {
            SubscriptedCustomerDTO subscriptedCustomerDTO = new SubscriptedCustomerDTO();

            subscriptedCustomerDTO.setId(subscriptedCustomerEntity.getId());
            subscriptedCustomerDTO.setName(subscriptedCustomerEntity.getName());
            subscriptedCustomerDTO.setAge(subscriptedCustomerEntity.getAge());
            subscriptedCustomerDTO.setMail(subscriptedCustomerEntity.getMail());

            return subscriptedCustomerDTO;
        }
    }

    @Override
    public SubscriptedCustomer toEntity(SubscriptedCustomerDTO subscriptedCustomerDTO) {

        SubscriptedCustomer subscriptedCustomerEntity = new SubscriptedCustomer();

        subscriptedCustomerEntity.setId(subscriptedCustomerDTO.getId());
        subscriptedCustomerEntity.setName(subscriptedCustomerDTO.getName());
        subscriptedCustomerEntity.setAge(subscriptedCustomerDTO.getAge());
        subscriptedCustomerEntity.setMail(subscriptedCustomerDTO.getMail());

        return subscriptedCustomerEntity;
    }
}
