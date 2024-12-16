package com.backend.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name ="customers")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class CustomerEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name ="age", nullable = false)
    private int age;

}
