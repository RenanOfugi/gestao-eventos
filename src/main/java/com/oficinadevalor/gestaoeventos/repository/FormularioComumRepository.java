package com.oficinadevalor.gestaoeventos.repository;

import com.oficinadevalor.gestaoeventos.model.FormularioComum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormularioComumRepository extends JpaRepository<FormularioComum, Long> {

    @Query("""
            SELECT form FROM FormularioComum form WHERE form.cpfCnpj = :cpfCnpj
            """)
    Optional<FormularioComum> findByPk(String cpfCnpj);
}
