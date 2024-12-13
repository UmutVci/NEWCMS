package com.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seats")
public class SeatEntity extends BaseEntity  {


    @Column(nullable = false)
    private String seatRow;

    @Column(nullable = false)
    private int seatColumn;

    @Column(nullable = false)
    private boolean isBooked = false;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private HallEntity hall;

    private String seatType;

}
