package com.example.tallerapi.service;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;
import com.example.tallerapi.domain.vehiculos;
import com.example.tallerapi.repository.clientesRepository;
import com.example.tallerapi.repository.vehiculosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

import java.util.List;

@Service
public class clientesServiceImplem implements clientesService {

    @Autowired
    private clientesRepository miClienteRepository;
    @Autowired
    private vehiculosRepository miVehiculosRepository;

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public List<clientes> findAll() {
        List<clientes> listado=miClienteRepository.findAll();
        ModelMapper mapper=new ModelMapper();
        List<clientes> listadoFinal=mapper.map(listado, (Type) clientesDTO.class);
        return listadoFinal;
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public clientes findById(long id) {
        clientes miCliente=miClienteRepository.findById(id);
        ModelMapper mapper=new ModelMapper();
        clientes miClienteFinal=mapper.map(miCliente, (Type) clientesDTO.class);

        return null;
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public clientes deleteCliente(long id) {
        clientes miCliente= miClienteRepository.findById(id);
        miClienteRepository.deleteById(id);
        ModelMapper mapper=new ModelMapper();
        clientes miClienteFinal=mapper.map(miCliente, (Type) clientesDTO.class);
        return miClienteFinal;
    }

    //TODO ¡¡¡¡¡Esta perfecto este!!!!
    @Override
    public clientes addCliente(clientesDTO clienteDTO){
        //Hay que alpliarlo porque tendria que lanzzar una excepcion con .orElseThrow
        vehiculos vehiculo= miVehiculosRepository.findById(clienteDTO.getVehiculos_id());
        //Ahora me crearia el objeto cliente y lo añadiria con .set...
        // pero como eso es un rollo lo mapeo*/
        //Me mapea el DTO sobre el objeto real
        ModelMapper mapper = new ModelMapper();
        clientes clienteNuevo = mapper.map(clienteDTO, clientes.class); //Con esto me mapea todos los atricbuto que son iguales
        //y yo copio a mano los que no estan en el DTO
        clienteNuevo.setVehiculo(vehiculo);
        return miClienteRepository.save(clienteNuevo);
    }

    //TODO no estoy seguro de que este bien
    @Override
    public clientes modifyCliente(clientes nuevoCliente, long id) {

        clientes miCliente= miClienteRepository.findById(id);
        ModelMapper mapper= new ModelMapper();
        clientes miCliente2=mapper.map(nuevoCliente, miCliente.getClass());
        return miCliente2;
    }
}
