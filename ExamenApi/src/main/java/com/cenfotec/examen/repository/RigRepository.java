package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.model.Rig;

public class RigRepository {

	@Repository
	public interface ContactRepository extends JpaRepository<Rig, String> {
	}

}
