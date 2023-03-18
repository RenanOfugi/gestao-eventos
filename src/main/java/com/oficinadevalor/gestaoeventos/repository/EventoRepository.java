package com.oficinadevalor.gestaoeventos.repository;

import com.oficinadevalor.gestaoeventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
