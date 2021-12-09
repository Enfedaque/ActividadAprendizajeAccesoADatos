package com.enfedaque.tallerapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Clientes")
public class clientes extends usuarios {

    @Column
    private boolean particular;
    @Column
    private boolean empresa;
    @Column(name = "nombre_empresa")
    private boolean nombreEmpresa;
    //1 cliente tiene 1 o "n" vehiculos, que los voy a guardar en una lista
    @OneToOne(mappedBy = "cliente")
    @JsonBackReference // TODO Aqui creo que fallara porque tiene que ser una List, no solo un objeto
    private vehiculos vehiculo;

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

    public vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }
}
