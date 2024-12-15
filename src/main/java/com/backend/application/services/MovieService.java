package com.backend.Application.services;


import com.backend.adapters.in.rest.dto.MovieDTO;
import com.backend.adapters.in.rest.dto.MovieFilter;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.domain.entities.MovieEntity;
import com.backend.domain.repository.BaseRepository;
import com.backend.domain.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService extends BaseService<MovieEntity, MovieDTO, Long> {

    @Autowired
    private IMovieRepository iMovieRepository;

    public MovieService(BaseRepository<MovieEntity, Long> repository, BaseMapper<MovieEntity, MovieDTO> mapper) {
        super(repository, mapper);
    }

    public List<MovieEntity> getMoviesByFilter(MovieFilter filter) {
        Specification<MovieEntity> spec = Specification.where(MovieSpecification.hasTitle(filter.getTitle()))
                .and(MovieSpecification.hasGenre(filter.getGenre()));

        return iMovieRepository.findAll(spec);
    }

}
