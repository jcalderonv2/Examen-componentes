package com.cenfotec.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.model.Biodiversity;


@Repository
public interface BiodiversityRepository extends JpaRepository<Biodiversity, Integer>{
	


}
