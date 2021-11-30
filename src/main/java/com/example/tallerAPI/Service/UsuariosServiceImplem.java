package com.example.tallerAPI.Service;

import com.example.tallerAPI.Domain.Usuarios;
import com.example.tallerAPI.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplem implements UsuariosService{

    @Autowired
    private UsuariosRepository miUsuariosRepository;

    @Override
    public List<Usuarios> findAll() {
        return miUsuariosRepository.findAll();
    }

    @Override
    public void cambiarEmail(String email) {

    }

    @Override
    public Usuarios findById(long id) {
        return miUsuariosRepository.findById(id);
    }

    @Override
    public Usuarios deleteUsuario(long id) {
        Usuarios miUsuario= miUsuariosRepository.findById(id);
        miUsuariosRepository.deleteById(id);
        return miUsuario;
    }

    @Override
    public Usuarios addUsuario(Usuarios usuario) {
        //Spring ya tiene el metodo "save" que da de alta nuevos campos
       return miUsuariosRepository.save(usuario);
    }

    @Override
    public Usuarios modifyUsuario(Usuarios nuevoUsuario, long id) {
        Usuarios miUsuario= miUsuariosRepository.findById(id);
        miUsuario.setNombre(nuevoUsuario.getNombre());
        miUsuario.setApellido(nuevoUsuario.getApellido());
        miUsuario.setDNI(nuevoUsuario.getDNI());
        miUsuario.setEdad(nuevoUsuario.getEdad());
        miUsuario.setEmail(nuevoUsuario.getEmail());
        miUsuario.setTelefono(nuevoUsuario.getTelefono());

        return miUsuariosRepository.save(miUsuario);
    }
}
