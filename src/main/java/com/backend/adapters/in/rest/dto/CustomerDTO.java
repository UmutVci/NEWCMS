package com.backend.adapters.in.rest.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class CustomerDTO extends BaseDTO {
    private Long id;

    @Setter
    @Getter
    private String name;

    public CustomerDTO( String name) {
        this.name = name;
    }

}