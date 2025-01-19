package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.ReservationDTO;
import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.adapters.in.rest.dto.SessionDTO;
import com.backend.adapters.in.rest.mapper.CustomerMapper;
import com.backend.adapters.in.rest.mapper.SeatMapper;
import com.backend.adapters.in.rest.mapper.SessionMapper;
import com.backend.application.services.BaseService;
import com.backend.application.services.MovieSpecification;
import com.backend.application.services.ReservationService;
import com.backend.application.services.SessionService;
import com.backend.domain.entities.ReservationEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController extends BaseController<ReservationEntity, ReservationDTO, Long>{
    @Autowired
    private final ReservationService reservationService;
    private final CustomerMapper customerMapper;
    private final SeatMapper seatMapper;
    private final SessionMapper sessionMapper;

    @Autowired
    public ReservationController(ReservationService reservationService, CustomerMapper customerMapper, SeatMapper seatMapper, SessionMapper sessionMapper) {
        super(reservationService);
        this.reservationService = reservationService;
        this.customerMapper = customerMapper;
        this.seatMapper = seatMapper;
        this.sessionMapper = sessionMapper;
    }

    @GetMapping("/{id}/discounted-price")
    public ResponseEntity<Double> calculateDiscountedPrice (@PathVariable("id") Long id,
                                                           @RequestParam("discountPercentage") Double discountPercentage)
    {
        Double discountedPrice = reservationService.calculateDiscountedPrice(id, discountPercentage);
        return ResponseEntity.ok(discountedPrice);
    }

    @GetMapping("/{id}/eligibility")
    public ResponseEntity <Boolean> checkCustomerEligibilty(@PathVariable("id") Long id)
    {
        boolean isEligible = reservationService.checkCustomerDiscountEligibility(id);
        return ResponseEntity.ok(isEligible);
    }

    @Override
    public Class<? extends BaseController<ReservationEntity, ReservationDTO, Long>> getControllerClass() {
        return ReservationController.class;
    }


}
