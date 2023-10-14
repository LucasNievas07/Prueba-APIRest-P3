package com.example.pruebaapirest.Repositories;

import com.example.pruebaapirest.Entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    //Anotacion metodo de Query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    //Anotacion query nativo
    @Query(
            value="SELECT * FROM persona WHERE persona.nombre LIKE '%:filtro%' OR persona.apellido LIKE '%:filtro%'",
            nativeQuery = true
    )
    List<Persona> searchNativo(String filtro);

    @Query(
            value="SELECT * FROM persona WHERE persona.nombre LIKE '%:filtro%' OR persona.apellido LIKE '%:filtro%'",
            countQuery = "SELECT count (*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(String filtro, Pageable pageable);
}
