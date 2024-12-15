package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.SessionDTO;
import com.backend.domain.entities.SessionEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@NoArgsConstructor
public class SessionMapper implements BaseMapper<SessionEntity, SessionDTO>
{
    private HallMapper hallMapper;
    private MovieMapper movieMapper;


    public SessionDTO toDto(SessionEntity sessionEntity)
    {
        SessionDTO dto = new SessionDTO();
        dto.setId(sessionEntity.getId());
        dto.setTime(sessionEntity.getStartTime().toString());
        dto.setMovieDTO(movieMapper.toDto(sessionEntity.getMovie()));
        dto.setHallDTO(hallMapper.toDto(sessionEntity.getHall()));
        dto.setPrice(dto.getPrice());
        return dto;
    }

    public SessionEntity toEntity(SessionDTO sessionDTO)
    {
        SessionEntity entity = new SessionEntity();
        entity.setId(sessionDTO.getId());
        entity.setStartTime(LocalDateTime.parse(sessionDTO.getTime())); // String -> LocalDateTime
        entity.setPrice(sessionDTO.getPrice());
        entity.setMovie(movieMapper.toEntity(sessionDTO.getMovieDTO()));
        entity.setHall(hallMapper.toEntity(sessionDTO.getHallDTO()));
        return entity;
    }
}
