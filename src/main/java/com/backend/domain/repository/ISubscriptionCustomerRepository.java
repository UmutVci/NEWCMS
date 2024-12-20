package com.backend.domain.repository;

import com.backend.domain.entities.SubscriptedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISubscriptionCustomerRepository extends BaseRepository<SubscriptedCustomer, Long> {
}
