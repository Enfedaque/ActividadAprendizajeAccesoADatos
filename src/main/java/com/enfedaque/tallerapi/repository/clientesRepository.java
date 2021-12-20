package com.enfedaque.tallerapi.repository;

import com.enfedaque.tallerapi.domain.clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clientesRepository extends CrudRepository<clientes, Long> {

    //Devuleve todos los cleintes
    List<clientes> findAll();

    List<clientes> findByParticularAndPresupuestoAndNombreEmpresa(boolean particular, int presupuestoEnReparaciones, String nombreEmpresa);

}
