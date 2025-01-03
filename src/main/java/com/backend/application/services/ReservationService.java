package com.backend.application.services;

import com.backend.adapters.in.rest.dto.ReservationDTO;
import com.backend.adapters.in.rest.mapper.ReservationMapper;
import com.backend.domain.entities.ReservationEntity;
import com.backend.domain.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private IReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;

    public List<ReservationDTO> getAllReservations()
    {
        List<ReservationEntity> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(reservationMapper::toDto)
                .collect(Collectors.toList());
    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO)
    {
        ReservationEntity reservationEntity = reservationMapper.toEntity(reservationDTO);
        ReservationEntity savedEntity = reservationRepository.save(reservationEntity);
        return reservationMapper.toDto(savedEntity);
    }

}
