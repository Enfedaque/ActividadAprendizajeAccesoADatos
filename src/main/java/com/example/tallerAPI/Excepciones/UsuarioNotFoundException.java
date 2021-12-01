package com.example.tallerAPI.Excepciones;

public class UsuarioNotFoundException extends  Exception{

    private static final String USUARIO_NO_ENCONTRADO = "Usuario no encontrado";

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException() {
        super(USUARIO_NO_ENCONTRADO);
    }
    
}
