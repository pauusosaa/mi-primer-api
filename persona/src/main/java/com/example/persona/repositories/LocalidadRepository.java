package com.example.persona.repositories;

import com.example.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{



    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:denominacion%",
            nativeQuery = true
    )
    List<Localidad> searchNativoLocalidad(@Param("denominacion") String denominacion);



    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:denominacion%",
            countQuery = "SELECT COUNT(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativoLocalidad(@Param("denominacion") String denominacion, Pageable pageable);
}
