package com.backend.adapters.in.rest.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class SeatDTO extends BaseDTO{
    private Long id;
    @Getter
    @Setter
    private String seatRow;
    private int seatColumn;
    private boolean isBooked;
    private HallDTO hallDTO;


}
