package com.jcerdeira.portfolio.repository;

import com.jcerdeira.portfolio.entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSkill extends JpaRepository<Skill, Integer> {

    Optional<Skill> findByNombreS(String nombreS);

    public boolean existsByNombreS(String nombreS);
}
