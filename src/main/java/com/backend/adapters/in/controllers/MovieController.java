package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.MovieDTO;
import com.backend.adapters.in.rest.dto.MovieFilter;
import com.backend.adapters.in.rest.mapper.MovieMapper;
import com.backend.application.services.BaseService;
import com.backend.application.services.MovieService;
import com.backend.domain.entities.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController extends BaseController<MovieEntity, MovieDTO, Long> {

    @Autowired
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieController(BaseService<MovieEntity, MovieDTO, Long> service, MovieService movieService, MovieMapper movieMapper) {
        super(service);
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }


    @PostMapping("/search")
    public ResponseEntity<List<MovieDTO>> searchMovie(@RequestBody MovieFilter movieFilter) {
        List<MovieEntity> movies = movieService.getMoviesByFilter(movieFilter);
        return ResponseEntity.ok(movies
                .stream()
                .map(movieMapper::toDto)
                .toList());
    }

    @Override
    public Class<? extends BaseController<MovieEntity, MovieDTO, Long>> getControllerClass() {
        return MovieController.class;
    }
}
