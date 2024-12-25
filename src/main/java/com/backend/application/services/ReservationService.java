package com.backend.application.services;

import com.backend.adapters.in.rest.dto.ReservationDTO;
import com.backend.adapters.in.rest.mapper.BaseMapper;
import com.backend.adapters.in.rest.mapper.ReservationMapper;
import com.backend.domain.entities.ReservationEntity;
import com.backend.domain.repository.BaseRepository;
import com.backend.domain.repository.IReservationRepository;
import com.backend.domain.repository.ISubscriptionCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService extends BaseService<ReservationEntity, ReservationDTO, Long>{

    @Autowired
    private IReservationRepository reservationRepository;
    @Autowired
    private ISubscriptionCustomerRepository subscriptionCustomerRepository;

    public ReservationService(BaseRepository<ReservationEntity, Long> repository, BaseMapper<ReservationEntity, ReservationDTO> mapper) {
        super(repository, mapper);
    }

    public Double calculateDiscountedPrice(Long id, Double discountPercentage) {
        ReservationEntity reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        Double originalPrice = reservation.getSession().getPrice();

        if (originalPrice <= 0) {
            throw new IllegalArgumentException("Invalid price: must be greater than 0");
        }
        if (discountPercentage <= 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage: must be between 0 and 100");
        }

        return originalPrice - (originalPrice * (discountPercentage / 100));
    }

    public boolean checkCustomerDiscountEligibility(Long customerId)
    {
        return subscriptionCustomerRepository.existsById(customerId);
    }

}
