package com.backend.domain.repository;

import com.backend.domain.entities.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISeatRepository extends BaseRepository<SeatEntity, Long> {

}
