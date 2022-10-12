package com.jcerdeira.portfolio.security.repository;

import com.jcerdeira.portfolio.security.entity.Rol;
import com.jcerdeira.portfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRol extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
