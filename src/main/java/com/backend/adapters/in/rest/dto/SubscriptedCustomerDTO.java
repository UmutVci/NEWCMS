package com.backend.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptedCustomerDTO extends BaseDTO {
    private String name;
    private int age;
    private String mail;
}
