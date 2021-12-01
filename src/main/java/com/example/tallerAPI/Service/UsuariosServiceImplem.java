package com.example.tallerAPI.Service;

import com.example.tallerAPI.Domain.Usuarios;
import com.example.tallerAPI.Excepciones.UsuarioNotFoundException;
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
    public Usuarios findById(long id) throws UsuarioNotFoundException{
        return miUsuariosRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException());
    }

    @Override
    public Usuarios deleteUsuario(long id) throws UsuarioNotFoundException{
        Usuarios miUsuario= miUsuariosRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException());;
        miUsuariosRepository.deleteById(id);
        return miUsuario;
    }

    @Override
    public Usuarios addUsuario(Usuarios usuario) {
        //Spring ya tiene el metodo "save" que da de alta nuevos campos
       return miUsuariosRepository.save(usuario);
    }

    @Override
    public Usuarios modifyUsuario(Usuarios nuevoUsuario, long id) throws UsuarioNotFoundException{
        Usuarios miUsuario= miUsuariosRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException());
        miUsuario.setNombre(nuevoUsuario.getNombre());
        miUsuario.setApellido(nuevoUsuario.getApellido());
        miUsuario.setDNI(nuevoUsuario.getDNI());
        miUsuario.setEdad(nuevoUsuario.getEdad());
        miUsuario.setEmail(nuevoUsuario.getEmail());
        miUsuario.setTelefono(nuevoUsuario.getTelefono());

        return miUsuariosRepository.save(miUsuario);
    }
}
