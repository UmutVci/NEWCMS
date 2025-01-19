package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.HallDTO;
import com.backend.domain.entities.HallEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class HallMapper implements BaseMapper<HallEntity, HallDTO> {

    @Autowired
    private SeatMapper seatMapper;
    private SessionMapper sessionMapper;

    @Override
    public HallDTO toDto(HallEntity hallEntity) {
        HallDTO hallDTO = new HallDTO();
        hallDTO.setId(hallEntity.getId());
        hallDTO.setName(hallEntity.getName());
        hallDTO.setCapacity(hallEntity.getCapacity());
        hallDTO.setType(hallEntity.getType());
        return hallDTO;
    }

    @Override
    public HallEntity toEntity(HallDTO dto) {
        HallEntity hallEntity = new HallEntity();
        hallEntity.setName(dto.getName());
        hallEntity.setCapacity(dto.getCapacity());
        hallEntity.setType(dto.getType());
        hallEntity.setUpdatedAt(LocalDateTime.now());
        return hallEntity;
    }

    @Override
    public void update(HallEntity hallEntity, HallDTO dto) {
        hallEntity.setName(dto.getName());
        hallEntity.setCapacity(dto.getCapacity());
        hallEntity.setType(dto.getType());
        hallEntity.setUpdatedAt(LocalDateTime.now());
    }

}
