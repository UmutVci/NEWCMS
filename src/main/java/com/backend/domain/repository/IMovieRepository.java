package com.backend.domain.repository;

import com.backend.domain.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends BaseRepository<MovieEntity, Long> {

}
