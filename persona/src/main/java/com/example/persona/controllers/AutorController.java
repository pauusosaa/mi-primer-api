package com.example.persona.controllers;

import com.example.persona.entities.Autor;
import com.example.persona.services.AutorServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{

    @GetMapping("/searchAutor")
    public ResponseEntity<?> searchAutor(@RequestParam String nombre){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchAutor(nombre));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPagedAutor")
    public ResponseEntity<?> searchAutor(@RequestParam String nombre, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchAutor(nombre, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}