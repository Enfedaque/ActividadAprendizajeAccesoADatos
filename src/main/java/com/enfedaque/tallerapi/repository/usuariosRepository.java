package com.enfedaque.tallerapi.repository;

import com.enfedaque.tallerapi.domain.empleados;
import com.enfedaque.tallerapi.domain.usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Similar al DAO
@Repository
public interface usuariosRepository extends CrudRepository<usuarios, Long> {

    /*Metodos como los del DAO, todos los que necesite
    METODOS QUE ACCEDEN A LA BBDD Y RECOGEN DATOS
    * Los find... tienen su miga, ya que solo con ese nombre se encarga de buscar la info en la BBDD*/

    //Devuleve todos los usuarios
    List<usuarios> findAll();

    //JPQL
    @Query("SELECT user FROM usuarios user WHERE nombre= :nombre")
    List<usuarios> findByNombre(String nombre);
}
