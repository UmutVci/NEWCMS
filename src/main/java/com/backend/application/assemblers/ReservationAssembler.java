package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.BaseController;
import com.backend.adapters.in.rest.dto.BaseDTO;

public class ReservationAssembler extends BaseAssembler<BaseDTO, Long, BaseController>{
    public ReservationAssembler(Class<BaseController> controllerClass) {
        super(controllerClass);
    }
}
