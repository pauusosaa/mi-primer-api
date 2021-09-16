package com.example.persona.services;

import com.example.persona.entities.Autor;
import com.example.persona.entities.Persona;
import com.example.persona.repositories.AutorRepository;
import com.example.persona.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> searchAutor(String nombre) throws Exception {
        try{
            List<Autor> autores = autorRepository.searchNativoAutor(nombre);
            return autores;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> searchAutor(String nombre, Pageable pageable) throws Exception {
        try{
            Page<Autor> autores = autorRepository.searchNativoAutor(nombre, pageable);
            return autores;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
