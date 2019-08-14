package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.model.DivPolitica;

@Repository
public interface DivPoliticaRepository extends JpaRepository<DivPolitica, Integer> {

}
