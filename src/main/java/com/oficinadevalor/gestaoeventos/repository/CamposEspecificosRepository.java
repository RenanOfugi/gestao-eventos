package com.oficinadevalor.gestaoeventos.repository;

import com.oficinadevalor.gestaoeventos.model.CampoEspecifico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposEspecificosRepository extends JpaRepository<CampoEspecifico, Long> {
}
