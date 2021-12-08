package com.example.tallerapi.excepciones;

public class usuarioNotFoundException extends  Exception{

    private static final String USUARIO_NO_ENCONTRADO = "Usuario no encontrado";

    public usuarioNotFoundException(String message) {
        super(message);
    }

    public usuarioNotFoundException() {
        super(USUARIO_NO_ENCONTRADO);
    }
    
}
