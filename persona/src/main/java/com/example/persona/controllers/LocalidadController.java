package com.example.persona.controllers;

import com.example.persona.entities.Localidad;
import com.example.persona.services.LocalidadServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {

    @GetMapping("/searchLocalidad")
    public ResponseEntity<?> searchLocalidad(@RequestParam String denominacion){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchLocalidad(denominacion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPagedLocalidad")
    public ResponseEntity<?> searchLocalidad(@RequestParam String denominacion, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchLocalidad(denominacion, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}