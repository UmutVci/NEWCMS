package com.backend.adapters.in.rest.dto;

import com.backend.domain.entities.CustomerEntity;
import com.backend.domain.entities.SeatEntity;
import com.backend.domain.entities.SessionEntity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class ReservationDTO extends BaseDTO{
    @NotNull
    private Long id;

    @Getter
    @Setter
    private SeatDTO seats;
    @NotEmpty
    private CustomerDTO customer;
    private SessionDTO sessions;

}
