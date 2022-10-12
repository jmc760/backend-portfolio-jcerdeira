package com.jcerdeira.portfolio.service;

import com.jcerdeira.portfolio.entity.Persona;
import com.jcerdeira.portfolio.repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {

    @Autowired
    RPersona rPersona;

    public List<Persona> list() {
        return rPersona.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return rPersona.findById(id);
    }

    public Optional<Persona> getByNombreP(String nombreP) {
        return rPersona.findByNombreP(nombreP);
    }

    public void save(Persona pers) {
        rPersona.save(pers);
    }

    public void delete(int id) {
        rPersona.deleteById(id);
    }

    public boolean existsById(int id) {
        return rPersona.existsById(id);
    }

    public boolean existsByNombreP(String nombreP) {
        return rPersona.existsByNombreP(nombreP);
    }
}

