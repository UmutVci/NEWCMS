package com.backend.adapters.in.controllers;

import com.backend.adapters.in.rest.dto.SessionDTO;
import com.backend.adapters.in.rest.mapper.HallMapper;
import com.backend.adapters.in.rest.mapper.MovieMapper;
import com.backend.application.services.BaseService;
import com.backend.application.services.SessionService;
import com.backend.domain.entities.SessionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/sessions")


public class SessionController extends BaseController<SessionEntity, SessionDTO,Long  > {
    @Autowired
    private SessionService sessionService;
    private final MovieMapper movieMapper;
    private final HallMapper hallMapper;
    @Autowired
    public SessionController(BaseService<SessionEntity, SessionDTO, Long> service, MovieMapper movieMapper, HallMapper hallMapper) {
        super(service);
        this.movieMapper = movieMapper;
        this.hallMapper = hallMapper;
    }

    @GetMapping("/{id}/session/end")
    public ResponseEntity<LocalDateTime> endTimeBySessionId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(sessionService.endTimeBySessionId(id));
    }

    @Override
    public Class<? extends BaseController<SessionEntity, SessionDTO, Long>> getControllerClass() {
        return SessionController.class;
    }


}
