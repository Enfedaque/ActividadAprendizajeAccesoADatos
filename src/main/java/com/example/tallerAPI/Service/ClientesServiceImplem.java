package com.example.tallerAPI.Service;

import com.example.tallerAPI.Domain.Clientes;
import com.example.tallerAPI.Domain.Usuarios;
import com.example.tallerAPI.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplem implements ClientesService{

    @Autowired
    private ClientesRepository miClienteRepository;

    @Override
    public List<Clientes> findAll() {
        return miClienteRepository.findAll();
    }

    @Override
    public void cambiarEmail(String email) {

    }

    @Override
    public Clientes findById(long id) {
        return miClienteRepository.findById(id);
    }

    @Override
    public Clientes deleteCliente(long id) {
        Clientes miCliente= miClienteRepository.findById(id);
        miClienteRepository.deleteById(id);
        return miCliente;
    }

    @Override
    public Clientes addCliente(Clientes cliente) {
        return miClienteRepository.save(cliente);
    }

    @Override
    public Clientes modifyCliente(Clientes cliente, long id) {
        return null;
    }
}
