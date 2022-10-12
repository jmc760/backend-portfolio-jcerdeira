package com.jcerdeira.portfolio.controller;

import com.jcerdeira.portfolio.dto.PersonaDTO;
import com.jcerdeira.portfolio.entity.Persona;
import com.jcerdeira.portfolio.security.controller.Mensaje;
import com.jcerdeira.portfolio.service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pers")
/*Local*/
/*@CrossOrigin(origins = "http://localhost:4200")*/
/*Producción*/
@CrossOrigin(origins = "https://frontend-jcerdeira.web.app")

public class CPersona {

    @Autowired
    SPersona sPersona;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("Elemento eliminado."), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDTO dtoper) {
        if (StringUtils.isBlank(dtoper.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sPersona.existsByNombreP(dtoper.getNombreP())) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe."), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtoper.getNombreP(), dtoper.getPuestoP(), dtoper.getUbicacionP());
        sPersona.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDTO dtoper) {
        //Validamos si existe el ID
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de personas
        if (sPersona.existsByNombreP(dtoper.getNombreP()) && sPersona.getByNombreP(dtoper.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe."), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoper.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Persona persona = sPersona.getOne(id).get();
        persona.setNombreP(dtoper.getNombreP());
        persona.setPuestoP((dtoper.getPuestoP()));
        persona.setUbicacionP((dtoper.getUbicacionP()));

        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada."), HttpStatus.OK);

    }
}
