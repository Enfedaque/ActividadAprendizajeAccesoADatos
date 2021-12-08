package com.example.tallerapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "empleados")
public class empleados extends usuarios {

    @Column
    private String puesto;
    @Column
    private String departamento;
    @Column
    private double salario;
}
