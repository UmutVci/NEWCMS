package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.MovieDTO;
import com.backend.domain.entities.MovieEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class MovieMapper implements BaseMapper<MovieEntity, MovieDTO> {
    @Autowired
    private SessionMapper sessionMapper;

    @Override
    public MovieDTO toDto(MovieEntity entity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setTitle(entity.getTitle());
        movieDTO.setGenre(entity.getGenre());
        movieDTO.setDuration(entity.getDuration());
        movieDTO.setPrice(entity.getPrice());
        return movieDTO;
    }

    @Override
    public MovieEntity toEntity(MovieDTO dto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(dto.getId());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setGenre(dto.getGenre());
        movieEntity.setDuration(dto.getDuration());
        movieEntity.setPrice(dto.getPrice());
        return movieEntity;
    }

    @Override
    public void update(MovieEntity movieEntity, MovieDTO dto) {
        movieEntity.setId(dto.getId());
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setGenre(dto.getGenre());
        movieEntity.setDuration(dto.getDuration());
        movieEntity.setPrice(dto.getPrice());
    }
}
