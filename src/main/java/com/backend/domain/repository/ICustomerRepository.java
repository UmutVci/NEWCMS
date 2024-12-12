package com.backend.domain.repository;

import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.domain.entities.CustomerEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository

public interface ICustomerRepository extends BaseRepository<CustomerEntity, Long> {
}
