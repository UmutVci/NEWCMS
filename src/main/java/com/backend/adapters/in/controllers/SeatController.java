package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.adapters.in.rest.mapper.HallMapper;
import com.backend.application.services.BaseService;
import com.backend.application.services.SeatService;
import com.backend.domain.entities.SeatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/seats")
public class SeatController extends BaseController<SeatEntity, SeatDTO, Long>{

    private final HallMapper hallMapper;

    @Autowired
    private final SeatService seatService;
    @Autowired
    public SeatController(BaseService<SeatEntity, SeatDTO, Long> service, HallMapper hallMapper, SeatService seatService)
    {
        super (service);
        this.hallMapper = hallMapper;
        this.seatService = seatService;
    }


    @Override
    public Class<? extends BaseController<SeatEntity, SeatDTO, Long>> getControllerClass() {
        return SeatController.class;
    }


}
