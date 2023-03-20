package com.oficinadevalor.gestaoeventos.service;

import com.oficinadevalor.gestaoeventos.model.TipoCampo;
import com.oficinadevalor.gestaoeventos.repository.TipoCampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCampoService {

    @Autowired
    private TipoCampoRepository repository;

    public List<TipoCampo> findAll(){
        return repository.findAll();
    }
}
