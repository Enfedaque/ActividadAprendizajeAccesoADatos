package com.example.tallerapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "vehiculos")
public class vehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehiculosID;
    //1 vehiculo tiene 1 dueño
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private clientes cliente;
    @Column(name = "fecha_entrada")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEntrada;
    @Column(name = "fecha_salida")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaSalida;

    public long getVehiculosID() {
        return vehiculosID;
    }

    public void setVehiculosID(long vehiculosID) {
        this.vehiculosID = vehiculosID;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
