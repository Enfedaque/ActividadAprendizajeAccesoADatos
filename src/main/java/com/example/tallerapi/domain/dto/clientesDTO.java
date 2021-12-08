package com.example.tallerapi.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class clientesDTO {
    /*
    El DTO es la forma que tengo de pasarle los datos en JSON, ya que no le puedo pasar un objeto entero
    como atricuto por ejemplo
     */
    private boolean particular;
    private boolean empresa;
    private boolean nombreEmpresa;
    private long vehiculos_id;

    public long getVehiculos_id() {
        return vehiculos_id;
    }

    public void setVehiculos_id(long vehiculos_id) {
        this.vehiculos_id = vehiculos_id;
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
