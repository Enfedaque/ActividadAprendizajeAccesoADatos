package com.enfedaque.tallerapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "empleados")
public class empleados extends usuarios {

    //No lo relaciono con un vehiculo porque un empleado puede tener al carho un vehiculo o no, o puede
    // registrarse un nuevo empleado que no se encargue de coches

    @Column
    private String puesto;
    @Column
    private String departamento;
    @Column
    private float salario;
    @Column
    private int operariosAlCargo;
    @Column
    private boolean isJefeDeTaller;
    @Column
    private LocalDate fechaComienzo;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getOperariosAlCargo() {
        return operariosAlCargo;
    }

    public void setOperariosAlCargo(int operariosAlCargo) {
        this.operariosAlCargo = operariosAlCargo;
    }

    public boolean isJefeDeTaller(boolean isJefeDeTaller) {
        return isJefeDeTaller;
    }
    public boolean isJefeDeTaller() {
        return isJefeDeTaller;
    }

    public void setJefeDeTaller(boolean jefeDeTaller) {
        isJefeDeTaller = jefeDeTaller;
    }

    public LocalDate getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(LocalDate fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }
}
