package com.cenfotec.examen.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen.model.Rig;
import com.cenfotec.examen.repository.RigRepository;

@RestController
@RequestMapping({ "/rigs" })
public class RigController {

	private RigRepository repository;

	RigController(RigRepository rigRepository) {
		this.repository = rigRepository;
	}

	@PostMapping
	public Rig create(@RequestBody Rig rig) {
		return repository.save(rig);
	}

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Rig> findById(@PathVariable String id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Rig> update(@PathVariable("id") String id, @RequestBody Rig rig) {
		return repository.findById(id).map(record -> {
			record.setIDENTIFICATION(rig.getIDENTIFICATION());
			record.setNAME(rig.getNAME());
			record.setCONTINENT(rig.getCONTINENT());
			record.setLAND(rig.getLAND());
			record.setSEA(rig.getSEA());
			Rig updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
