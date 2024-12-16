package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.HallDTO;
import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.application.services.BaseService;
import com.backend.application.services.HallService;
import com.backend.domain.entities.HallEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hall")
public class HallController extends BaseController<HallEntity, HallDTO, Long> {
    private HallService hallService;

    public HallController(BaseService<HallEntity, HallDTO, Long> service) {
        super(service);
    }

    @GetMapping("/{id}/seats/full")
    public ResponseEntity<Boolean> isAllSeatsFull(@PathVariable("id") Long id) {
        return ResponseEntity.ok(hallService.isAllSeatsFullByHallId(id));
    }

    @GetMapping("/{id}/seats/empty")
    public ResponseEntity<List<SeatDTO>> showEmptySeats(@PathVariable("id") Long id) {
        return ResponseEntity.ok(hallService.showEmptySeats(id));
    }

}
