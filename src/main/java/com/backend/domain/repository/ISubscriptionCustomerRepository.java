package com.backend.domain.repository;

import com.backend.domain.entities.SubscriptedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriptionCustomerRepository extends BaseRepository<SubscriptedCustomer, Long> {
    @Query(value = "select COUNT(s) from SubscriptedCustomer s where s.id = :id")
    public int isSub(@Param("id") Long id);
}
