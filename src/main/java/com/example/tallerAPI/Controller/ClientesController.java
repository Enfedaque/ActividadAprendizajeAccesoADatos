package com.example.tallerAPI.Controller;

import com.example.tallerAPI.Domain.Clientes;
import com.example.tallerAPI.Domain.Usuarios;
import com.example.tallerAPI.Service.ClientesService;
import com.example.tallerAPI.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientesController {

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private ClientesService miClienteService;

    //Metodo que me devuelva el total de clientes
    @GetMapping("/Clientes") //Forma de buscarlo en el navegador
    public List<Clientes> getClientes(){
        List<Clientes> clientes=miClienteService.findAll();
        return clientes;
    }

    //Metodo que me devuelve un cliente concreto segun su id
    @GetMapping("/Clientes/{ClienteId}")
    public Clientes getCliente(@PathVariable long id){
        Clientes miCliente=miClienteService.findById(id);
        return miCliente;
    }

    //Añadir nuevo cliente
    @PostMapping("/Clientes")
    public Clientes addCliente(@RequestBody Clientes cliente){
        Clientes miCliente= miClienteService.addCliente(cliente);
        return miCliente;
    }

    //Eliminar cliente
    @DeleteMapping("/Clientes/{ClienteId}")
    public  Clientes deleteCliente(@PathVariable long id){
        Clientes miCliente= miClienteService.deleteCliente(id);
        return miCliente;
    }
}
