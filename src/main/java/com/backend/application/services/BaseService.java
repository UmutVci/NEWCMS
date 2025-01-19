package com.backend.application.services;

import com.backend.adapters.in.rest.dto.BaseDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.domain.repository.BaseRepository;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseService<T, D extends BaseDTO, ID extends Serializable> {

    private final BaseRepository<T, ID> repository;
    private final BaseMapper<T, D> mapper;

    public BaseService(BaseRepository<T, ID> repository, BaseMapper<T, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<D> findAll() {
        List<T> entities = repository.findAll();
        return entities.stream().map(mapper::toDto).toList();
    }

    public Optional<D> findById(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(mapper::toDto);
    }

    public D save(D dto) {
        T entity = mapper.toEntity(dto);
        T savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    public D update(D dto, ID id){
        D databaseElement = findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Entity with that id couldnt find" + id)
        );
        T entity = mapper.toEntity(databaseElement);
        mapper.update(entity, dto);
        T savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);

    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
