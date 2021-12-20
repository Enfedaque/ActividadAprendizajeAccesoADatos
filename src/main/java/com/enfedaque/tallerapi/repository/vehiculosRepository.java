package com.enfedaque.tallerapi.repository;

import com.enfedaque.tallerapi.domain.vehiculos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface vehiculosRepository extends CrudRepository<vehiculos, Long> {

    List<vehiculos> findAll();

    List<vehiculos> findByMatriculaAndKilometrosAndAntiguedad(String matricula, float kilometros, int antiguedad);
}
