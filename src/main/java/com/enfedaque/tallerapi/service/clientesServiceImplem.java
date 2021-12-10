package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;
import com.enfedaque.tallerapi.repository.clientesRepository;
import com.enfedaque.tallerapi.repository.vehiculosRepository;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.domain.vehiculos;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

import java.util.List;

@Service
public class clientesServiceImplem implements clientesService{

    @Autowired
    private clientesRepository miClienteRepository;
    @Autowired
    private vehiculosRepository miVehiculosRepository;

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public List<clientesDTO> findAll() {
        List<clientes> listado=miClienteRepository.findAll();
        ModelMapper mapper=new ModelMapper();
        List<clientesDTO> listadoFinal=mapper.map(listado, (Type) clientesDTO.class);
        return listadoFinal;
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public clientesDTO findById(long id) throws clienteNotFoundException {
        clientes miCliente=miClienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundException());

        ModelMapper mapper=new ModelMapper();
        clientesDTO miClienteFinal=mapper.map(miCliente, (Type) clientesDTO.class);
        return miClienteFinal;
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public clientes deleteCliente(long id) throws clienteNotFoundException {
        clientes miCliente= miClienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundException());
        miClienteRepository.deleteById(id);
        ModelMapper mapper=new ModelMapper();
        clientes miClienteFinal=mapper.map(miCliente, (Type) clientesDTO.class);
        return miClienteFinal;
    }

    //TODO ¡¡¡¡¡Esta perfecto este!!!!
    @Override
    public clientes addCliente(clientesDTO clienteDTO) throws vehiculoNotFoundException {
        //Hay que alpliarlo porque tendria que lanzzar una excepcion con .orElseThrow
        vehiculos vehiculo= miVehiculosRepository.findById(clienteDTO.getVehiculos_id())
                .orElseThrow(() -> new vehiculoNotFoundException());
        //Ahora me crearia el objeto cliente y lo añadiria con .set...
        // pero como eso es un rollo lo mapeo*/
        //Me mapea el DTO sobre el objeto real
        ModelMapper mapper = new ModelMapper();
        clientes clienteNuevo = mapper.map(clienteDTO, clientes.class); //Con esto me mapea todos los atricbuto que son iguales
        //y yo copio a mano los que no estan en el DTO
        clienteNuevo.setVehiculo(vehiculo);
        return miClienteRepository.save(clienteNuevo);
    }

    //TODO creo casi seguro que esta mal
    @Override
    public clientes modifyCliente(clientesDTO clienteDTO, long id) throws clienteNotFoundException {

        clientes miCliente= miClienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundException());
        ModelMapper mapper= new ModelMapper();
        clientes miCliente2=mapper.map(clienteDTO, miCliente.getClass());
        return miCliente2;
    }

    @Override
    public clientes changeParameters(clientesDTO clienteDTO, long id) throws clienteNotFoundException {
        clientes miCliente=miClienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundException());

        //TODO no se como hacerlo


        return null;
    }
}
