package com.example.tallerAPI.Controller;

import com.example.tallerAPI.Domain.Usuarios;
import com.example.tallerAPI.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    //Parte con la que interactue el usuario
    //Metodos invocables desde cualquier navegador

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private UsuariosService miUsuariosService;

    //Metodo que me devuelva el total de usuarios
    @GetMapping("/Usuarios") //Forma de buscarlo en el navegador
    public List<Usuarios> getUsuarios(){
        List<Usuarios> usuarios=miUsuariosService.findAll();
        return usuarios;
    }

    //Metodo que me devuelve un usuario concreto segun su id
    @GetMapping("/Usuarios/{UsuariosId}")
    public Usuarios getUsuario(@PathVariable long id){
        Usuarios miUsuarios=miUsuariosService.findById(id);
        return miUsuarios;
    }

    //Borrar un usuario por el id
    @DeleteMapping("/Usuarios/{UsuariosId}")
    public  Usuarios deleteUsuario(@PathVariable long id){
        Usuarios miUsuario=miUsuariosService.deleteUsuario(id);
        return miUsuario;
    }

    //Añadir un nuevo usuario
    @PostMapping("/Usuarios")
    public Usuarios addUsuario(@RequestBody Usuarios usuario){
        Usuarios miUsuario=miUsuariosService.addUsuario(usuario);
        return miUsuario;
    }

    //Modificar un usuario por el id
    @PutMapping("/Usuarios/{UsuariosId}")
    public Usuarios modifyUsuario(@RequestBody Usuarios usuario, @PathVariable long id){
        Usuarios miUsuario=miUsuariosService.modifyUsuario(usuario, id);
        return miUsuario;
    }
}
