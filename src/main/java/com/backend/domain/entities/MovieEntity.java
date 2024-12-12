package com.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movies")
public class MovieEntity extends BaseEntity  {



    @Column(name = "movie_id")
    private String title;
    private String genre;
    private Integer duration;
    private Double price;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SessionEntity> sessions = new ArrayList<>();

}
