package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.model.DivRegBiologica;

@Repository
public interface DivRegBiologicaRepository extends JpaRepository<DivRegBiologica, Integer>{

}
