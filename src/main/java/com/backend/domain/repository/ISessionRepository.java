package com.backend.domain.repository;

import com.backend.domain.entities.SeatEntity;
import com.backend.domain.entities.SessionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionRepository extends BaseRepository<SessionEntity, Long> {
}
