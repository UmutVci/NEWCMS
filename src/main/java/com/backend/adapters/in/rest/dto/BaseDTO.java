package com.backend.adapters.in.rest.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
public class BaseDTO {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
