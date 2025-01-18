package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.BaseController;
import com.backend.adapters.in.rest.dto.BaseDTO;

public class SeatAssembler extends BaseAssembler<BaseDTO, Long, BaseController>{
    public SeatAssembler(Class<BaseController> controllerClass) {
        super(controllerClass);
    }
}
