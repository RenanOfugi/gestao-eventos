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

    @Transactional
    public Evento update(EventoRequestDto requestDto, Long id) {
        return repository.findById(id).map(evento -> {
          Evento eventoUpdate = MAPPER.requestDtoToEntity(requestDto);
          updateEvento(eventoUpdate, evento);
          return evento;
        }).orElseThrow(() -> {
            throw new EntityNotFoundException("Não há evento para este id");
        });
    }

    private void updateEvento(Evento eventoUpdate, Evento evento){
        evento.setNome(eventoUpdate.getNome());
        evento.setDescricao(eventoUpdate.getDescricao());
        evento.setEmpresa(eventoUpdate.getEmpresa());
        evento.setDataCriacao(eventoUpdate.getDataCriacao());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
