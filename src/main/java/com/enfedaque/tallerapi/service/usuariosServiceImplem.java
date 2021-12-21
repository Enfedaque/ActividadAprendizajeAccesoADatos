package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.usuarios;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.repository.usuariosRepository;
import org.modelmapper.ModelMapper;
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

    //TODO Aqui esta mal
    @Override
    public usuarios modifyUsuario(usuarios nuevoUsuario, long id) throws usuarioNotFoundException {
        usuarios miUsuario= miUsuariosRepository.findById(id)
                .orElseThrow(() -> new usuarioNotFoundException());

        ModelMapper mapper=new ModelMapper();
        usuarios usuarioModificado=mapper.map(miUsuario, usuarios.class);
        return miUsuariosRepository.save(usuarioModificado);
    }

    @Override
    public List<usuarios> findByNombre(String nombre) {
        return miUsuariosRepository.findByNombre(nombre);
    }
}
