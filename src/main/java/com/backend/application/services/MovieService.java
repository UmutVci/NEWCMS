package com.backend.Application.services;


import com.backend.adapters.in.rest.dto.MovieDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.domain.entities.MovieEntity;
import com.backend.domain.repository.BaseRepository;
import com.backend.domain.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends BaseService<MovieEntity, MovieDTO, Long> {

    @Autowired
    private IMovieRepository iMovieRepository;

    public MovieService(BaseRepository<MovieEntity, Long> repository, BaseMapper<MovieEntity, MovieDTO> mapper) {
        super(repository, mapper);
    }

}
