package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.excepciones.respuestaErrores;
import com.enfedaque.tallerapi.service.usuariosService;
import com.enfedaque.tallerapi.domain.usuarios;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class usuariosController {

    //Parte con la que interactue el usuario
    //Metodos invocables desde cualquier navegador

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private usuariosService miUsuariosService;

    //Metodo que me devuelva el TOTAL DE USUARIOS
    @GetMapping("/Usuarios") //Forma de buscarlo en el navegador
    public List<usuarios> getUsuarios(){
        List<usuarios> usuarios=miUsuariosService.findAll();
        return usuarios;
    }

    //Metodo que me devuelve un USUARIO SEGUN ID
    //TODO Terminado, sin probar
    @GetMapping("/Usuarios/{UsuariosId}")
    public usuarios getUsuario(@PathVariable long id) throws usuarioNotFoundException {
        usuarios miUsuarios=miUsuariosService.findById(id);
        return miUsuarios;
    }

    //BORRAR un usuario por el id
    //TODO Terminado, sin probar
    @DeleteMapping("/Usuarios/{UsuariosId}")
    public usuarios deleteUsuario(@PathVariable long id) throws usuarioNotFoundException {
        usuarios miUsuario=miUsuariosService.deleteUsuario(id);
        return miUsuario;
    }

    //AÑADIR un nuevo usuario
    //TODO Terminado, sin probar
    @PostMapping("/Usuarios")
    public usuarios addUsuario(@RequestBody usuarios usuario){
        usuarios miUsuario=miUsuariosService.addUsuario(usuario);
        return miUsuario;
    }

    //MODIFICAR un usuario por el id
    //TODO Terminado, sin probar
    @PutMapping("/Usuarios/{UsuariosId}")
    public usuarios modifyUsuario(@RequestBody usuarios usuario, @PathVariable long id)
            throws usuarioNotFoundException {
        usuarios miUsuario=miUsuariosService.modifyUsuario(usuario, id);
        return miUsuario;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(usuarioNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerUsuarioNoEncontrado(usuarioNotFoundException unfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", unfe.getMessage());
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
