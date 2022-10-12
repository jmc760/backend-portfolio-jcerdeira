package com.jcerdeira.portfolio.security.service;

import com.jcerdeira.portfolio.security.entity.Rol;
import com.jcerdeira.portfolio.security.enums.RolNombre;
import com.jcerdeira.portfolio.security.repository.IRol;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRol {

    @Autowired
    IRol irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
