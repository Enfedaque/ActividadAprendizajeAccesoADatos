package com.example.tallerAPI.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Clientes")
public class Clientes extends Usuarios{

    @Column
    private long ID_Cliente;

    @Column
    private long ID_vehiculo;

    public long getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(long ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public long getID_vehiculo() {
        return ID_vehiculo;
    }

    public void setID_vehiculo(long ID_vehiculo) {
        this.ID_vehiculo = ID_vehiculo;
    }
}
