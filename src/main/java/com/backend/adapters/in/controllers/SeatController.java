package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.application.services.BaseService;
import com.backend.domain.entities.SeatEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seat")
public class SeatController extends BaseController<SeatEntity, SeatDTO, Long>{

    public SeatController(BaseService<SeatEntity, SeatDTO, Long> service)
    {
        super(service);
    }



}
