package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.excepciones.respuestaErrores;
import com.enfedaque.tallerapi.service.usuariosService;
import com.enfedaque.tallerapi.domain.usuarios;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class usuariosController {

    private final Logger logger = LoggerFactory.getLogger(usuariosController.class);

    //Parte con la que interactue el usuario
    //Metodos invocables desde cualquier navegador

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private usuariosService miUsuariosService;

    //Metodo que me devuelva el TOTAL DE USUARIOS
    @GetMapping("/Usuarios") //Forma de buscarlo en el navegador
    public List<usuarios> getUsuarios(){
        logger.info("Inicio getUsuarios");
        List<usuarios> usuarios=miUsuariosService.findAll();
        logger.info("Fin operacion de mostrado de usuarios");
        return usuarios;
    }

    //Metodo que me devuelve un USUARIO SEGUN ID
    //TODO Terminado, sin probar
    @GetMapping("/Usuarios/{id}")
    public usuarios getUsuario(@PathVariable long id) throws usuarioNotFoundException {
        logger.info("Inicio busqueda de usuario con id: " + id);
        usuarios miUsuarios=miUsuariosService.findById(id);
        logger.info("Fin de la operacion de busqueda");
        return miUsuarios;
    }

    //BORRAR un usuario por el id
    //TODO Terminado, sin probar
    @DeleteMapping("/Usuarios/{id}")
    public usuarios deleteUsuario(@PathVariable long id) throws usuarioNotFoundException {
        logger.info("Inicio deleteUsuario");
        usuarios miUsuario=miUsuariosService.deleteUsuario(id);
        logger.info("Usuario con id: " + miUsuario.getId() + " eliminado. FIN de la operación");
        return miUsuario;
    }

    //AÑADIR un nuevo usuario
    //TODO Terminado, sin probar
    @PostMapping("/Usuarios")
    public usuarios addUsuario(@RequestBody usuarios usuario){
        logger.info("Inicio AddUsuario");
        usuarios miUsuario=miUsuariosService.addUsuario(usuario);
        logger.info("Usuario con id: " + miUsuario.getId() + " añadido. FIN de la operación");
        return miUsuario;
    }

    //MODIFICAR un usuario por el id
    //TODO Terminado, sin probar
    @PutMapping("/Usuarios/{id}")
    public usuarios modifyUsuario(@RequestBody usuarios usuario, @PathVariable long id)
            throws usuarioNotFoundException {
        logger.info("Inicio modificar usuario con id: " + id);
        usuarios miUsuario=miUsuariosService.modifyUsuario(usuario, id);
        logger.info("Usuario con id: " + miUsuario.getId() + " modificada. FIN de la operación");
        return miUsuario;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(usuarioNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerUsuarioNoEncontrado(usuarioNotFoundException unfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", unfe.getMessage());
        logger.error(unfe.getMessage(), unfe);
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
