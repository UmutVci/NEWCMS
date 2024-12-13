package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.domain.entities.SeatEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper implements BaseMapper<SeatEntity, SeatDTO>
{
    @Override
    public SeatDTO toDto(SeatEntity seatEntity)
    {
        if (seatEntity == null)
        {
            return null;
        }
        SeatDTO dto = new SeatDTO();
        dto.setId(seatEntity.getId());
        dto.setSeatRow(seatEntity.getSeatRow());
        dto.setSeatColumn(seatEntity.getSeatColumn());
        dto.setBooked(seatEntity.isBooked());
        dto.setHallDTO(seatEntity.getHall());
        return dto;
    }

    @Override
    public SeatEntity toEntity(SeatDTO seatDTO)
    {
        if (seatDTO == null)
        {
            return null;
        }
        SeatEntity entity = new SeatEntity();
        entity.setSeatRow(entity.getSeatRow());
        entity.setSeatColumn(entity.getSeatColumn());
        entity.setBooked(entity.isBooked());
        entity.setHall(entity.getHall());
        return entity;
    }
}
