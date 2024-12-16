package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.HallDTO;
import com.backend.domain.entities.HallEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class HallMapper implements BaseMapper<HallEntity, HallDTO> {

    private SeatMapper seatMapper;
    private SessionMapper sessionMapper;

    @Override
    public HallDTO toDto(HallEntity hallEntity) {
        HallDTO hallDTO = new HallDTO();
        hallDTO.setId(hallEntity.getId());
        hallDTO.setName(hallEntity.getName());
        hallDTO.setCapacity(hallEntity.getCapacity());
        hallDTO.setType(hallEntity.getType());
        hallDTO.setSessionDTOS(hallEntity.getSessions()
                .stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList()));
        hallDTO.setSeatDTOS(hallEntity.getSeats()
                .stream()
                .map(seatMapper::toDto)
                .collect(Collectors.toList()));
        return hallDTO;
    }

    @Override
    public HallEntity toEntity(HallDTO dto) {
        HallEntity hallEntity = new HallEntity();
        hallEntity.setName(dto.getName());
        hallEntity.setType(dto.getType());
        hallEntity.setUpdatedAt(LocalDateTime.now());
        hallEntity.setSessions(dto.getSessionDTOS()
                .stream()
                .map(sessionMapper::toEntity)
                .collect(Collectors.toList()));
        hallEntity.setSeats(dto.getSeatDTOS()
                .stream()
                .map(seatMapper::toEntity)
                .collect(Collectors.toList()));
        return hallEntity;
    }

}
