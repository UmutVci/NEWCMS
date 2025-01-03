package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.SubscriptedCustomerDTO;
import com.backend.domain.entities.SubscriptedCustomer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SubscriptedCustomerMapper implements BaseMapper<SubscriptedCustomer, SubscriptedCustomerDTO> {

    @Override
    public SubscriptedCustomerDTO toDto(SubscriptedCustomer subscriptedCustomerEntity) {
            SubscriptedCustomerDTO subscriptedCustomerDTO = new SubscriptedCustomerDTO();
            subscriptedCustomerDTO.setId(subscriptedCustomerEntity.getId());
            subscriptedCustomerDTO.setAge(subscriptedCustomerEntity.getAge());
            subscriptedCustomerDTO.setMail(subscriptedCustomerEntity.getMail());

            return subscriptedCustomerDTO;
    }

    @Override
    public SubscriptedCustomer toEntity(SubscriptedCustomerDTO subscriptedCustomerDTO) {

        SubscriptedCustomer subscriptedCustomerEntity = new SubscriptedCustomer();

        subscriptedCustomerEntity.setId(subscriptedCustomerDTO.getId());
        subscriptedCustomerEntity.setAge(subscriptedCustomerDTO.getAge());
        subscriptedCustomerEntity.setMail(subscriptedCustomerDTO.getMail());

        return subscriptedCustomerEntity;
    }
}
