package com.oficinadevalor.gestaoeventos.service;

import com.oficinadevalor.gestaoeventos.exceptions.EntityNotFoundException;
import com.oficinadevalor.gestaoeventos.mapper.EventoMapper;
import com.oficinadevalor.gestaoeventos.model.Evento;
import com.oficinadevalor.gestaoeventos.model.dtos.EventoRequestDto;
import com.oficinadevalor.gestaoeventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;
    private static final EventoMapper MAPPER = EventoMapper.INSTANCE;
    public Page<Evento> findAll(PageRequest pageable) {
        return repository.findAll(pageable);
    }

    public Evento findById(Long id) {
        return repository.findById(id).orElseThrow(()-> {
            throw new EntityNotFoundException("Evento não localizado");
        });
    }

    @Transactional
    public Evento create(EventoRequestDto requestDto) {
        return repository.save(MAPPER.requestDtoToEntity(requestDto));
    }
}
