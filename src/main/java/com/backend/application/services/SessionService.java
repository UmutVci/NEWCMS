package com.backend.application.services;

import com.backend.adapters.in.rest.dto.SessionDTO;

import com.backend.adapters.in.rest.mapper.SessionMapper;

import com.backend.domain.entities.SessionEntity;

import com.backend.domain.repository.ISessionRepository;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;


@Service
public class SessionService extends BaseService<SessionEntity, SessionDTO , Long> {

    @Autowired
    private ISessionRepository sessionRepository;
    @Autowired
    private SessionMapper sessionMapper;


    public SessionService(ISessionRepository sessionRepository, SessionMapper mapper) {
        super(sessionRepository, mapper);
    }

    public SessionDTO createSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = sessionMapper.toEntity(sessionDTO);
        SessionEntity savedSession = sessionRepository.save(sessionEntity);
        return sessionMapper.toDto(savedSession);
    }


    public LocalDateTime endTimeBySessionId(Long sessionId) {
        SessionEntity session = sessionRepository.findById(sessionId).orElseThrow(() ->
                new ResourceNotFoundException("Session not found with ID" + sessionId));
        int movieDuration = session.getMovie().getDuration();
        return session.getStartTime().plusMinutes(movieDuration);
    }


}
