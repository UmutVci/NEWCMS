package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.ReservationDTO;
import com.backend.domain.entities.ReservationEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ReservationMapper implements BaseMapper<ReservationEntity, ReservationDTO>
{
    private CustomerMapper customerMapper;
    private SeatMapper seatMapper;
    private SessionMapper sessionMapper;

    @Override
    public ReservationDTO toDto(ReservationEntity reservationEntity) {
        if (reservationEntity == null) {
            return null;
        }
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservationEntity.getId());
        dto.setCustomer(customerMapper.toDto(reservationEntity.getCustomer()));
        dto.setSeats(seatMapper.toDto(reservationEntity.getSeat()));
        dto.setSessions(sessionMapper.toDto(reservationEntity.getSession()));
        return dto;
    }

    @Override
    public ReservationEntity toEntity(ReservationDTO reservationDTO) {
        if (reservationDTO == null) {
            return null;
        }

        ReservationEntity entity = new ReservationEntity();
        entity.setCustomer(customerMapper.toEntity(reservationDTO.getCustomer()));
        entity.setSeat(seatMapper.toEntity(reservationDTO.getSeats()));
        entity.setSession(sessionMapper.toEntity(reservationDTO.getSessions()));
        return entity;
    }
}
