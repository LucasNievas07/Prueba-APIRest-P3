package com.example.pruebaapirest.Services;

import com.example.pruebaapirest.Entities.Localidad;
import com.example.pruebaapirest.Repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
