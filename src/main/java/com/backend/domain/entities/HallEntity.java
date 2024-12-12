package com.backend.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "halls")
public class HallEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer capacity;

    private String type;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SessionEntity> sessions = new ArrayList<>();

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatEntity> seats = new ArrayList<>();

}
