package com.example.tallerapi.domain.dto;

import com.example.tallerapi.domain.clientes;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class vehiculosDTO {
    /*
    El DTO es la forma que tengo de pasarle los datos en JSON, ya que no le puedo pasar un objeto entero
    como atricuto por ejemplo
     */
    private long cliente_id; //Le paso el id, y no el objeto entero
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
}
