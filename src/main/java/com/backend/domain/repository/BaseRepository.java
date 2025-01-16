package com.backend.domain.repository;

import com.backend.adapters.in.rest.dto.BaseDTO;
import com.backend.domain.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@NoRepositoryBean
@Repository
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}