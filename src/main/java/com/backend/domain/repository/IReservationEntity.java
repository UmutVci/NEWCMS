package com.backend.domain.repository;

import com.backend.domain.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IReservationEntity extends BaseRepository<ReservationEntity, Long> {
}
