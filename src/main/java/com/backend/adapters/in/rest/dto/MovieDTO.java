package com.backend.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO extends BaseDTO {
    private String title;
    private String genre;
    private int duration;
    private double price;

}
