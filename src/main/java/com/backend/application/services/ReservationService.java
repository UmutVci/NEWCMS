package com.backend.Application.services;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    /*
    @Autowired
    private IReservationRepository reservationRepository;
    @Autowired
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
    */
    // ARKADASLAR KIM BURAYA MAPPER KODLARINI YAZDI AQ YANLISLIKLA MI GELDI BILMIYOM KALSIN BURDA
    // KIM KODLUCAKSA BURAYI SILEBILIR ZATEN RESERVATIONMAPPER DA AYNI KODLAR VAR
}
