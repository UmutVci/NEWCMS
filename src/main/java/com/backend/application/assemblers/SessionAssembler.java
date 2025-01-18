package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.SessionController;
import com.backend.adapters.in.rest.dto.SessionDTO;

public class SessionAssembler extends BaseAssembler<SessionDTO, Long, SessionController>{
    public SessionAssembler(Class<SessionController> controllerClass) {
        super(controllerClass);
    }
}
