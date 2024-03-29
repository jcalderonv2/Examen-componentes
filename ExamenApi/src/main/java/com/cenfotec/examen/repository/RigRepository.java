package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.model.Rig;

@Repository
public interface RigRepository extends JpaRepository<Rig, Integer> {
}
