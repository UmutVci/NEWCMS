package com.backend.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO extends BaseDTO{
    private String seatRow;
    private int seatColumn;
    private boolean isBooked;
    private HallDTO hallDTO;
    private String seatType;


}
