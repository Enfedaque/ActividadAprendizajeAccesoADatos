package com.enfedaque.tallerapi.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
public class clientesDTO {
    /*
    El DTO es la forma que tengo de pasarle los datos en JSON, ya que no le puedo pasar un objeto entero
    como atricuto por ejemplo
     */
    private boolean particular;
    private LocalDate fechaAlta;
    private int presupuestoEnReparaciones;
    private float estatura;
    private boolean empresa;
    private boolean nombreEmpresa;
     //No puedo hacer una lista de long para los id


    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getPresupuestoEnReparaciones() {
        return presupuestoEnReparaciones;
    }

    public void setPresupuestoEnReparaciones(int presupuestoEnReparaciones) {
        this.presupuestoEnReparaciones = presupuestoEnReparaciones;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public boolean isParticular() {
        return particular;
    }

    public void setParticular(boolean particular) {
        this.particular = particular;
    }

    public boolean isEmpresa() {
        return empresa;
    }

    public void setEmpresa(boolean empresa) {
        this.empresa = empresa;
    }

    public boolean isNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(boolean nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
