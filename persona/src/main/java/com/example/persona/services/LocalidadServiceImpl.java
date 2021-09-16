package com.example.persona.services;

import com.example.persona.entities.Localidad;
import com.example.persona.entities.Persona;
import com.example.persona.repositories.BaseRepository;
import com.example.persona.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService{

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Localidad> searchLocalidad(String denominacion) throws Exception {
        try{
            List<Localidad> localidades = localidadRepository.searchNativoLocalidad(denominacion);
            return localidades;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Localidad> searchLocalidad(String denominacion, Pageable pageable) throws Exception {
        try {
            Page<Localidad> localidades = localidadRepository.searchNativoLocalidad(denominacion, pageable);
            return localidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
