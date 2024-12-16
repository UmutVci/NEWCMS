package com.backend.application.services;

import com.backend.domain.entities.MovieEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {
    public static Specification<MovieEntity> hasTitle(String title) {
        return (Root<MovieEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                title != null ? cb.like(root.get("title"), "%" + title + "%") : null;
    }

    public static Specification<MovieEntity> hasGenre(String genre) {
        return (Root<MovieEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                genre != null ? cb.equal(root.get("genre"), genre) : null;
    }
}
