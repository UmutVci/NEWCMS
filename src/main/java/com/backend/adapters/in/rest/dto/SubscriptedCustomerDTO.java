package com.backend.adapters.in.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class SubscriptedCustomerDTO extends BaseDTO {
    private Long id;
    private String name;
    private int age;
    private String mail;
}
