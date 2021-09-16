package com.example.persona.services;

import com.example.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadService extends BaseService<Localidad, Long> {
    List<Localidad> searchLocalidad(String denominacion) throws Exception;
    Page<Localidad> searchLocalidad(String denominacion, Pageable pageable) throws Exception;
}
