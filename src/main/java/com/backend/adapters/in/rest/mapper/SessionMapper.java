package com.backend.adapters.in.rest.mapper;

import com.backend.adapters.in.rest.dto.SessionDTO;
import com.backend.domain.entities.HallEntity;
import com.backend.domain.entities.MovieEntity;
import com.backend.domain.entities.SessionEntity;
import com.backend.domain.repository.IHallRepository;
import com.backend.domain.repository.IMovieRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SessionMapper implements BaseMapper<SessionEntity, SessionDTO>
{
    public SessionDTO toDto(SessionEntity sessionEntity)
    {
        if ( sessionEntity == null )
        {
            return null;
        }
        SessionDTO dto = new SessionDTO();
        dto.setId(sessionEntity.getId());
        dto.setTime(sessionEntity.getStartTime().toString());
        dto.setMovieTitle(sessionEntity.getMovie().getTitle());
        dto.setHallName(sessionEntity.getHall().getName());
        dto.setPrice(dto.getPrice());
        return dto;
    }

    public SessionEntity toEntity(SessionDTO sessionDTO, IMovieRepository movieRepository, IHallRepository hallRepository)
    {
        SessionEntity entity = new SessionEntity();
        entity.setId(sessionDTO.getId());
        entity.setStartTime(LocalDateTime.parse(sessionDTO.getTime())); // String -> LocalDateTime
        entity.setPrice(sessionDTO.getPrice());
        MovieEntity movieEntity = movieRepository.findByTitle(sessionDTO.getMovieTitle());
        entity.setMovie(movieEntity);

        HallEntity hallEntity = hallRepository.findByName(sessionDTO.getHallName());
        entity.setHall(hallEntity);
        return entity;
    }
}
