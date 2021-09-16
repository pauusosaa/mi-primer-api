package com.example.persona.services;

import com.example.persona.entities.Autor;
import com.example.persona.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutorService extends BaseService<Autor, Long> {
    List<Autor> searchAutor(String nombre) throws Exception;
    Page<Autor> searchAutor(String nombre, Pageable pagealbe) throws Exception;
}
