package com.example.persona.repositories;

import com.example.persona.entities.Autor;
import com.example.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository <Autor, Long> {



    @Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE %:nombre%",
            nativeQuery = true
    )
    List<Autor> searchNativoAutor(@Param("nombre") String nombre);



    @Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE %:nombre%",
            countQuery = "SELECT COUNT(*) FROM autor",
            nativeQuery = true
    )
    Page<Autor> searchNativoAutor (@Param("nombre") String nombre, Pageable pageable);
}