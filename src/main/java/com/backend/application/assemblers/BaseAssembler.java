package com.backend.application.assemblers;

import com.backend.adapters.in.controllers.BaseController;
import com.backend.adapters.in.controllers.CustomerController;
import com.backend.adapters.in.rest.dto.BaseDTO;
import com.backend.adapters.in.rest.dto.CustomerDTO;
import com.backend.application.services.BaseService;
import com.backend.domain.entities.BaseEntity;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public abstract class BaseAssembler<T extends BaseDTO, ID extends Serializable, C extends BaseController> implements RepresentationModelAssembler<T, EntityModel<T>> {

     final Class<C> controllerClass;

    public BaseAssembler(Class<C> controllerClass) {
        this.controllerClass = controllerClass;
    }

    @Override
    public EntityModel<T> toModel(T entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(controllerClass).findById(entity.getId())).withSelfRel(),
                linkTo(methodOn(controllerClass).findAll()).withRel("all-entities")
                );
    }

}
