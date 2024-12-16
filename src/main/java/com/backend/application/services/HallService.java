package com.backend.application.services;

import com.backend.adapters.in.rest.dto.HallDTO;
import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.adapters.in.rest.mapper.SeatMapper;
import com.backend.domain.entities.HallEntity;
import com.backend.domain.entities.SeatEntity;
import com.backend.domain.repository.BaseRepository;
import com.backend.domain.repository.IHallRepository;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallService extends BaseService<HallEntity, HallDTO, Long> {
    private SeatMapper seatMapper;
    @Autowired
    private IHallRepository iHallRepository;

    public HallService(BaseRepository<HallEntity, Long> repository, BaseMapper<HallEntity, HallDTO> mapper) {
        super(repository, mapper);
    }

    public boolean isAllSeatsFullByHallId(Long id) {
        HallEntity hallEntity = iHallRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Hall with that id couldnt find + " + id)
                );
        List<SeatEntity> seatEntities = hallEntity.getSeats();
        for (SeatEntity seat : seatEntities) {
            if (!seat.isBooked()) {
                return false;
            }
        }
        return true;
    }

    public List<SeatDTO> showEmptySeats(Long id) {
        HallEntity hall = iHallRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Hall with that id couldnt find " + id)
                );
        List<SeatEntity> seatEntities = hall.getSeats();
        return seatEntities
                .stream()
                .map(seatMapper::toDto)
                .filter(c -> !c.isBooked())
                .collect(Collectors.toList());
    }



}
