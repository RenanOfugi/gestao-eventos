package com.oficinadevalor.gestaoeventos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formulario_especifico")
public class FormularioEspecifico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String titulo;

    @Column
    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_tipo_campo", referencedColumnName = "id")
    private TipoCampo tipoCampo;

    @ManyToOne
    @JoinColumn(name = "id_form_comum", referencedColumnName = "id")
    private FormularioComum formularioComum;
}
