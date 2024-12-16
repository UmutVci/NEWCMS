package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.domain.entities.SeatEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SeatMapper implements BaseMapper<SeatEntity, SeatDTO> {

    private final HallMapper hallMapper = new HallMapper();

    @Override
    public SeatDTO toDto(SeatEntity seatEntity)
    {
        SeatDTO dto = new SeatDTO();
        dto.setId(seatEntity.getId());
        dto.setSeatRow(seatEntity.getSeatRow());
        dto.setSeatColumn(seatEntity.getSeatColumn());
        dto.setBooked(seatEntity.isBooked());
        dto.setHallDTO(hallMapper.toDto(seatEntity.getHall()));
        return dto;
    }

    @Override
    public SeatEntity toEntity(SeatDTO seatDTO)
    {
        SeatEntity entity = new SeatEntity();
        entity.setSeatRow(entity.getSeatRow());
        entity.setSeatColumn(entity.getSeatColumn());
        entity.setBooked(entity.isBooked());
        entity.setHall(hallMapper.toEntity(seatDTO.getHallDTO()));
        return entity;
    }
}
