package com.backend.adapters.in.controllers;

import com.backend.application.services.BaseService;
import com.backend.adapters.in.rest.dto.BaseDTO;
import com.backend.exceptions.ResourceNotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<D>> findAll() {
        List<D> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public EntityModel<D> findById(@PathVariable ID id) {
        D entity = service.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Entity with that id couldnt find " + id)
        );
        // TODO : inside of methodOn must be generics
        return EntityModel.of(entity, linkTo(methodOn(CustomerController.class).findById((Long) id)).withSelfRel());
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
}
