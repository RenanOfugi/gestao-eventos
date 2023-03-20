package com.oficinadevalor.gestaoeventos.service;

import com.oficinadevalor.gestaoeventos.enums.TipoCampoEnum;
import com.oficinadevalor.gestaoeventos.exceptions.EntityNotAllowedException;
import com.oficinadevalor.gestaoeventos.exceptions.EntityNotFoundException;
import com.oficinadevalor.gestaoeventos.mapper.FormularioComumMapper;
import com.oficinadevalor.gestaoeventos.model.Evento;
import com.oficinadevalor.gestaoeventos.model.FormularioComum;
import com.oficinadevalor.gestaoeventos.model.TipoCampo;
import com.oficinadevalor.gestaoeventos.model.dtos.FormularioComumCreateRequestDto;
import com.oficinadevalor.gestaoeventos.model.dtos.FormularioComumUpdateRequestDto;
import com.oficinadevalor.gestaoeventos.repository.FormularioComumRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FormularioComumService {

    private static final FormularioComumMapper MAPPER = FormularioComumMapper.INSTANCE;
    private final FormularioComumRepository repository;
    private final EventoService eventoService;
    private final List<TipoCampo> tipoCampos;

    @Autowired
    public FormularioComumService(FormularioComumRepository repository, EventoService eventoService, TipoCampoService tipoCampoService) {
        this.repository = repository;
        this.eventoService = eventoService;
        this.tipoCampos = tipoCampoService.findAll();
    }

    @Transactional
    public FormularioComum create(FormularioComumCreateRequestDto requestDto) {
        FormularioComum formulario = MAPPER.dtoCreateToEntity(requestDto);
        formulario.setEvento(getEvent(requestDto.idEvento()));
        setTipoCamposCreate(formulario);
        return repository.save(formulario);
    }

    @Transactional
    public FormularioComum update(FormularioComumUpdateRequestDto requestDto, Long id) {
        FormularioComum formulario = findById(id);
        FormularioComum formularioUpdate = MAPPER.dtoCreateToEntity(requestDto);
        setTipoCamposUpdate(formularioUpdate, formulario);
        updateData(formularioUpdate, formulario);
        formulario.setEvento(getEvent(requestDto.idEvento()));
        return repository.save(formulario);
    }

    private void setTipoCamposCreate(FormularioComum formulario) {
        formulario.getCampoEspecificos().forEach(formularioEspecifico -> {
            formularioEspecifico.setTipoCampo(findTipoCampoInList(formularioEspecifico.getTipoCampo().getTipo()));
            formularioEspecifico.setFormularioComum(formulario);
        });
    }

    private void setTipoCamposUpdate(FormularioComum formularioUpdate, FormularioComum formulario) {
        formularioUpdate.getCampoEspecificos().forEach(formularioEspecifico -> {
            formularioEspecifico.setTipoCampo(findTipoCampoInList(formularioEspecifico.getTipoCampo().getTipo()));
            formularioEspecifico.setFormularioComum(formulario);
        });
    }

    private void updateData(FormularioComum formularioUpdate, FormularioComum formulario) {

        formulario.setNome(formularioUpdate.getNome());
        formulario.setEmail(formularioUpdate.getEmail());
        formulario.setEndereco(formularioUpdate.getEndereco());
        formulario.setValor(formularioUpdate.getValor());
        formulario.setCampoEspecificos(formularioUpdate.getCampoEspecificos());
    }

    @Transactional
    public FormularioComum findByPk(String cpfCnpj) {
        return repository.findByPk(cpfCnpj)
                .map(formularioComum -> {
                    Hibernate.initialize(formularioComum.getCampoEspecificos());
                    return formularioComum;
                })
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Formulário não encontrado");
                });
    }

    public FormularioComum findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Formulário não encontrado");
        });
    }

    @Transactional
    private Evento getEvent(Long idEvento) {
        return Optional.of(eventoService.findById(idEvento)).orElseThrow(() -> {
            throw new EntityNotAllowedException("Evento não encontrado");
        });
    }

    private TipoCampo findTipoCampoInList(TipoCampoEnum tipoCampoEnum) {
        return tipoCampos.stream()
                .filter(tipoCampo -> tipoCampo.getTipo().equals(tipoCampoEnum))
                .findFirst()
                .orElseThrow(() -> {
                    throw new EntityNotAllowedException("tipo " + tipoCampoEnum.name() + " do campo não permitido");
                });
    }

    @Transactional
    public Page<FormularioComum> findAll(PageRequest pageable) {
        Page<FormularioComum> formularioComumPage = repository.findAll(pageable);
        formularioComumPage.forEach(formularioComum -> Hibernate.initialize(formularioComum.getCampoEspecificos()));
        return formularioComumPage;
    }
}
