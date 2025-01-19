package com.backend.adapters.in.rest.mapper;

import org.springframework.stereotype.Component;

@Component
public interface BaseMapper<T, D> {
     D toDto(T entity);

     T toEntity(D dto);

     void update(T entity, D dto);
}