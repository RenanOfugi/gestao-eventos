package com.oficinadevalor.gestaoeventos.controller;

import com.oficinadevalor.gestaoeventos.model.Evento;
import com.oficinadevalor.gestaoeventos.model.dtos.EventoRequestDto;
import com.oficinadevalor.gestaoeventos.service.EventoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Validated
@RestController
@RequestMapping("/v1/evento")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public ResponseEntity<Page<Evento>> findAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "15") int size,
                                                @RequestParam(defaultValue = "DESC") Sort.Direction direction,
                                                @RequestParam(defaultValue = "id") String sort) {
        return ResponseEntity.ok(service.findAll(PageRequest.of(page, size, Sort.by(direction, sort))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evento> create(@RequestBody @Valid EventoRequestDto requestDto, HttpServletRequest request) {
        Evento evento = service.create(requestDto);
        return ResponseEntity.created(URI.create(request.getRequestURL().append("/").append(evento.getId()).toString())).build();
    }
}
