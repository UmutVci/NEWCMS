package com.backend.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO extends BaseDTO{
    private SeatDTO seats;
    private CustomerDTO customer;
    private SessionDTO sessions;
}
