package com.example.tallerapi.service;

import com.example.tallerapi.domain.usuarios;
import com.example.tallerapi.excepciones.usuarioNotFoundException;
import com.example.tallerapi.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usuariosServiceImplem implements usuariosService {

    @Autowired
    private usuariosRepository miUsuariosRepository;

    @Override
    public List<usuarios> findAll() {
        return miUsuariosRepository.findAll();
    }

    @Override
    public void cambiarEmail(String email) {

    }

    @Override
    public usuarios findById(long id) throws usuarioNotFoundException {
        return miUsuariosRepository.findById(id)
                .orElseThrow(() -> new usuarioNotFoundException());
    }

    @Override
    public usuarios deleteUsuario(long id) throws usuarioNotFoundException {
        usuarios miUsuario= miUsuariosRepository.findById(id)
                .orElseThrow(() -> new usuarioNotFoundException());;
        miUsuariosRepository.deleteById(id);
        return miUsuario;
    }

    @Override
    public usuarios addUsuario(usuarios usuario) {
        //Spring ya tiene el metodo "save" que da de alta nuevos campos
       return miUsuariosRepository.save(usuario);
    }

    @Override
    public usuarios modifyUsuario(usuarios nuevoUsuario, long id) throws usuarioNotFoundException {
        usuarios miUsuario= miUsuariosRepository.findById(id)
                .orElseThrow(() -> new usuarioNotFoundException());
        /*miUsuario.setNombre(nuevoUsuario.getNombre());
        miUsuario.setApellido(nuevoUsuario.getApellido());
        miUsuario.setDNI(nuevoUsuario.getDNI());
        miUsuario.setEdad(nuevoUsuario.getEdad());
        miUsuario.setEmail(nuevoUsuario.getEmail());
        miUsuario.setTelefono(nuevoUsuario.getTelefono());*/

        return miUsuariosRepository.save(miUsuario);
    }
}
