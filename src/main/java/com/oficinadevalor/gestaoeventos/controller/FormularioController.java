package com.oficinadevalor.gestaoeventos.controller;

import com.oficinadevalor.gestaoeventos.model.FormularioComum;
import com.oficinadevalor.gestaoeventos.model.dtos.FormularioComumCreateRequestDto;
import com.oficinadevalor.gestaoeventos.model.dtos.FormularioComumUpdateRequestDto;
import com.oficinadevalor.gestaoeventos.service.FormularioComumService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Validated
@RestController
@RequestMapping("/v1/formulario")
public class FormularioController {

    @Autowired
    private FormularioComumService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormularioComum> create(@RequestBody @Valid FormularioComumCreateRequestDto requestDto, HttpServletRequest request){
        FormularioComum formulario = service.create(requestDto);
        return ResponseEntity.created(URI.create(request.getRequestURL().append("/").append(formulario.getId()).toString())).build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormularioComum> update(@RequestBody @Valid FormularioComumUpdateRequestDto requestDto, @RequestParam Long id){
        return ResponseEntity.ok(service.update(requestDto, id));
    }

    @GetMapping
    public ResponseEntity<Page<FormularioComum>> findAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "15") int size,
                                                         @RequestParam(defaultValue = "DESC") Sort.Direction direction,
                                                         @RequestParam(defaultValue = "id") String sort){
        return ResponseEntity.ok(service.findAll(PageRequest.of(page, size, Sort.by(direction, sort))));
    }

    @GetMapping("/{cpfCnpj}")
    public ResponseEntity<FormularioComum> findByPk(@PathVariable String cpfCnpj){
        return ResponseEntity.ok(service.findByPk(cpfCnpj));
    }
}
