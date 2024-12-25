package com.backend.application.services;

import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.adapters.in.rest.mapper.SeatMapper;
import com.backend.domain.entities.SeatEntity;
import com.backend.domain.repository.ISeatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeatService extends BaseService<SeatEntity, SeatDTO, Long>{

    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private SeatMapper seatMapper;

    public SeatService(ISeatRepository seatRepository, SeatMapper mapper)
    {
        super(seatRepository, mapper);
    }


}
