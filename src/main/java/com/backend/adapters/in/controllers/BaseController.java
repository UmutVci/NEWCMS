package com.backend.adapters.in.controllers;

import com.backend.application.services.BaseService;
import com.backend.adapters.in.rest.dto.BaseDTO;
import com.backend.exceptions.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public abstract class BaseController<T, D extends BaseDTO, ID extends Serializable> {

    private final BaseService<T, D, ID> service;

    public BaseController(BaseService<T, D, ID> service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<D>> findAll() {
        List<EntityModel<D>> entityModels = service.findAll()
                .stream()
                .map(D -> EntityModel.of(D,
                            linkTo(methodOn(getControllerClass()).findById((ID) D.getId())).withSelfRel()
                        ))
                .toList();
        return CollectionModel.of(entityModels, linkTo(methodOn(getControllerClass()).findAll()).withRel("all-entities"));
    }


    @GetMapping("/{id}")
    public EntityModel<D> findById(@PathVariable ID id) {
        D entity = service.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Entity with that id couldnt find " + id)
        );
        return EntityModel.of(entity,
                linkTo(methodOn(getControllerClass()).findById(id)).withSelfRel(),
                linkTo(methodOn(getControllerClass()).findAll()).withRel("all-entities")
        );
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D dto) {
        D savedDto = service.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/"+savedDto.getId())
                .buildAndExpand(savedDto.getId())
                .toUri();
        // 201 Created ve Location başlığı döndür
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        service.deleteById(id);
        URI collectionUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/resource")
                .build()
                .toUri();
        return ResponseEntity.noContent().location(collectionUri).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody D dto, @PathVariable ID id){

        D updatedEntity = service.update(dto, id);
        EntityModel<D> entityModel = EntityModel.of(
                updatedEntity,
                linkTo(methodOn(getClass()).update(dto, id)).withSelfRel(), // Self link
                linkTo(methodOn(getClass()).findAll()).withRel("all-entities"));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);

    }
    
    public abstract Class<? extends BaseController<T,D , ID>> getControllerClass();

}
