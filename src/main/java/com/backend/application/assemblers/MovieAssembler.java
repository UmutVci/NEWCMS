package com.backend.application.assemblers;
import com.backend.adapters.in.controllers.MovieController;
import com.backend.adapters.in.rest.dto.MovieDTO;

public class MovieAssembler extends BaseAssembler<MovieDTO, Long, MovieController>{

    public MovieAssembler(Class<MovieController> controllerClass) {
        super(controllerClass);
    }
}
