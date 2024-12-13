package com.backend.domain.repository;

import com.backend.domain.entities.HallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("hallRepository")
public interface IHallRepository extends BaseRepository<HallEntity, Long> {
    HallEntity findByName(String title);
}
