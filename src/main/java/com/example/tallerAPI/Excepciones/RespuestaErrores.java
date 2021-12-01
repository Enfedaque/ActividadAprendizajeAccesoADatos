package com.example.tallerAPI.Excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaErrores {

    private String error;
    private String mensaje;



    //Casi nunca me funciona lo de que me monte el construcotr y los getter y setter

}
