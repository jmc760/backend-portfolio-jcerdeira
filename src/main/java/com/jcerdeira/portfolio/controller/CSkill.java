package com.jcerdeira.portfolio.controller;

import com.jcerdeira.portfolio.dto.SkillDTO;
import com.jcerdeira.portfolio.entity.Skill;
import com.jcerdeira.portfolio.security.controller.Mensaje;
import com.jcerdeira.portfolio.service.SSkill;
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
/*Local*/
/*@CrossOrigin(origins = "http://localhost:4200")*/
/*Producción*/
@CrossOrigin(origins = "https://frontend-jcerdeira.web.app")
@RequestMapping("/skill")
public class CSkill {

    @Autowired
    SSkill sSkill;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        sSkill.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado."), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDTO dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sSkill.existsByNombreS(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe."), HttpStatus.BAD_REQUEST);
        }

        Skill skill = new Skill(dtoskill.getNombreS(), dtoskill.getPorcentajeS());
        sSkill.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDTO dtoskill) {
        //Validamos si existe el ID
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sSkill.existsByNombreS(dtoskill.getNombreS()) && sSkill.getByNombreS(dtoskill.getNombreS()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe."), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skill skill = sSkill.getOne(id).get();
        skill.setNombreS(dtoskill.getNombreS());
        skill.setPorcentajeS(dtoskill.getPorcentajeS());

        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada."), HttpStatus.OK);

    }
}
