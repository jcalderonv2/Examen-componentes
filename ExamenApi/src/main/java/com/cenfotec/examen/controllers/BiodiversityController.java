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

import com.cenfotec.examen.model.Biodiversity;
import com.cenfotec.examen.repository.BiodiversityRepository;

@RestController
@RequestMapping({ "/bios" })
public class BiodiversityController {
	
	private BiodiversityRepository repository;

	BiodiversityController(BiodiversityRepository biodiversityRepository) {
		this.repository = biodiversityRepository;
	}

	@PostMapping
	public Biodiversity create(@RequestBody Biodiversity bio) {
		return repository.save(bio);
	}

	@GetMapping
	public List findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public List<Biodiversity> biodiversitycountrylist(@PathVariable Integer id) {
		
		List<Biodiversity> biodiversityBD = null;
		List<Biodiversity> listBiodiversity = new ArrayList<Biodiversity>();

		biodiversityBD = repository.findAll();

		for (Biodiversity bd : biodiversityBD) {
			if (bd.getCOUNTRY() == id) {
				listBiodiversity.add(bd);
			}
		}
		return listBiodiversity;
	}
	
	@GetMapping(path = "/{id}/{type}")
	public List<Biodiversity> animalcountrylist(@PathVariable Integer id, @PathVariable Integer type) {
		
		List<Biodiversity> biodiversityBD = null;
		List<Biodiversity> listBiodiversity = new ArrayList<Biodiversity>();

		biodiversityBD = repository.findAll();

		for (Biodiversity bd : biodiversityBD) {
			
			
			if (bd.getCOUNTRY() == id && bd.getTYPE() == type) {
				listBiodiversity.add(bd);
			}
		}
		return listBiodiversity;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Biodiversity> update(@PathVariable("id") Integer id, @RequestBody Biodiversity bio) {
		return repository.findById(id).map(record -> {
			record.setCODE(bio.getCODE());
			record.setTYPE(bio.getTYPE());
			record.setPOPULARNAME(bio.getPOPULARNAME());
			record.setSCIENTIFICNAME(bio.getSCIENTIFICNAME());
			record.setINDANGER(bio.getINDANGER());
			record.setPOPULATION(bio.getPOPULATION());
			record.setCOUNTRY(bio.getCOUNTRY());

			Biodiversity updated = repository.save(record);
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
