package com.enfedaque.tallerapi.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class respuestaErrores {

    private String error;
    private String mensaje;

    public respuestaErrores(String error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    //Casi nunca me funciona el @Data
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }



}