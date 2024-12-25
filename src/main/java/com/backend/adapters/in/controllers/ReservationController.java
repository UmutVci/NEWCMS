package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.ReservationDTO;
import com.backend.adapters.in.rest.dto.SeatDTO;
import com.backend.adapters.in.rest.dto.SessionDTO;
import com.backend.application.services.BaseService;
import com.backend.application.services.MovieSpecification;
import com.backend.application.services.ReservationService;
import com.backend.application.services.SessionService;
import com.backend.domain.entities.ReservationEntity;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController extends BaseController<ReservationEntity, ReservationDTO, Long>{
    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        super(reservationService);
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}/discounted-price")
    public ResponseEntity<Double> calculateDiscountedPrice(@PathVariable("id") Long id,
                                                           @RequestParam("discountPercentage") Double discountPercentage)
    {
        Double discountedPrice = reservationService.calculateDiscountedPrice(id, discountPercentage);
        return ResponseEntity.ok(discountedPrice);
    }

    @GetMapping("/{id}/eligibility")
    public ResponseEntity<Boolean> checkCustomerEligibilty(@PathVariable("id") Long id)
    {
        boolean isEligible = reservationService.checkCustomerDiscountEligibility(id);
        return ResponseEntity.ok(isEligible);
    }
}
