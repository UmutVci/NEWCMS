package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.BaseController;
import com.backend.adapters.in.rest.dto.BaseDTO;

public class HallAssembler extends BaseAssembler<BaseDTO, Long, BaseController>{
    public HallAssembler(Class<BaseController> controllerClass) {
        super(controllerClass);
    }
}
