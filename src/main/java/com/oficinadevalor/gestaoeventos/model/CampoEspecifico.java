package com.oficinadevalor.gestaoeventos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "campo_especifico")
public class CampoEspecifico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String titulo;

    @Column
    private String valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_tipo_campo", referencedColumnName = "id")
    private TipoCampo tipoCampo;

    @ManyToOne
    @JoinColumn(name = "id_form_comum", referencedColumnName = "id")
    @JsonBackReference
    private FormularioComum formularioComum;
}
