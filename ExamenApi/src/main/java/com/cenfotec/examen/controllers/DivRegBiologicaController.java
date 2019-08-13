package com.cenfotec.examen.controllers;

import java.util.ArrayList;
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

import com.cenfotec.examen.model.DivRegBiologica;
import com.cenfotec.examen.repository.DivRegBiologicaRepository;

@RestController
@RequestMapping({ "/divbiologicas" })
public class DivRegBiologicaController {
	
	private DivRegBiologicaRepository repository;

	DivRegBiologicaController(DivRegBiologicaRepository divRegBiologicaRepository) {
		this.repository = divRegBiologicaRepository;
	}
	
	
	@PostMapping
	public DivRegBiologica create(@RequestBody DivRegBiologica divBio) {
		return repository.save(divBio);
	}

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public List<DivRegBiologica> divBiologicaCountryList(@PathVariable Integer id) {
		
		List<DivRegBiologica> divBiologicaBD = null;
		List<DivRegBiologica> listDivBiologica = new ArrayList<DivRegBiologica>();

		divBiologicaBD = repository.findAll();

		for (DivRegBiologica bd : divBiologicaBD) {
			if (bd.getRIG() == id) {
				listDivBiologica.add(bd);
			}
		}
		return listDivBiologica;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<DivRegBiologica> update(@PathVariable("id") Integer id, @RequestBody DivRegBiologica divBio) {
		return repository.findById(id).map(record -> {
			record.setCODE(divBio.getCODE());
			record.setNAME(divBio.getNAME());
			record.setDIVPOLITICA(divBio.getDIVPOLITICA());
			record.setRIG(divBio.getRIG());

			DivRegBiologica updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
