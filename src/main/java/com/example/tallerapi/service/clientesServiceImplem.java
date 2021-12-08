package com.example.tallerapi.service;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;
import com.example.tallerapi.domain.vehiculos;
import com.example.tallerapi.excepciones.usuarioNotFoundException;
import com.example.tallerapi.repository.clientesRepository;
import com.example.tallerapi.repository.vehiculosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

    @Override
    public void cambiarEmail(String email) {

    }

    @Override
    public clientes findById(long id) {
        return miClienteRepository.findById(id);
    }

    @Override
    public clientes deleteCliente(long id) {
        clientes miCliente= miClienteRepository.findById(id);
        miClienteRepository.deleteById(id);
        return miCliente;
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

    @Override
    public clientes modifyCliente(clientesDTO clienteDTO, long id) {
        //TODO
        // Aqui tengo que pensar como hacerlo porque aunque lo haga con DTO, al modificar
        // el vehiculo_id, puede que el nuevo id exista o no y dara fallo, ademas de ver como
        // hacer que al pasar el id nuevo lo convierta a un objeto vehiculo, ya que creo
        // que tendria que crear un nuevo vehiculo con ese id y es un lio*/
        return null;
    }
}
