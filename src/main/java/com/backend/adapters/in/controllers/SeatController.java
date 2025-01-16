package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.application.services.BaseService;
import com.backend.application.services.SeatService;
import com.backend.domain.entities.SeatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seats")
public class SeatController extends BaseController<SeatEntity, SeatDTO, Long>{

    @Autowired
    private final SeatService seatService;
    @Autowired
    public SeatController(BaseService<SeatEntity, SeatDTO, Long> service, SeatService seatService)
    {
        super (service);
        this.seatService = seatService;
    }



}
