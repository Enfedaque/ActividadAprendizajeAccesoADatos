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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID_Cliente;
    @Column
    private long ID_vehiculo;
}
