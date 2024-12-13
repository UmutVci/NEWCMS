package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.ReservationDTO;
import com.backend.domain.entities.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public interface BaseMapper<T, D> {
    D toDto(T entity);

    T toEntity(D dto);
}