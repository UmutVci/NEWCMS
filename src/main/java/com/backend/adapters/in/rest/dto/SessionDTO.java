package com.backend.adapters.in.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SessionDTO extends BaseDTO
{
    private Long id;
    private String time;
    private String movieTitle;
    private String hallName;
    private double price;
}
