package com.backend.Application.services;

import com.backend.adapters.in.rest.dto.HallDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.domain.entities.HallEntity;
import com.backend.domain.entities.SeatEntity;
import com.backend.domain.repository.BaseRepository;
import com.backend.domain.repository.IHallRepository;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService extends BaseService<HallEntity, HallDTO, Long> {

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


}
