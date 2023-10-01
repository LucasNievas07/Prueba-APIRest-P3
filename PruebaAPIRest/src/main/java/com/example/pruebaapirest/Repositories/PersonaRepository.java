package com.example.pruebaapirest.Repositories;

import com.example.pruebaapirest.Entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
