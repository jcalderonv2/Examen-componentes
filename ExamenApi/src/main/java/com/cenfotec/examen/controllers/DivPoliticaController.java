package com.cenfotec.examen.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen.model.DivPolitica;
import com.cenfotec.examen.repository.DivPoliticaRepository;

@RestController
@RequestMapping({ "/divpoliticas" })
public class DivPoliticaController {

	private DivPoliticaRepository repository;

	DivPoliticaController(DivPoliticaRepository divPoliticaRepository) {
		this.repository = divPoliticaRepository;
	}

	@PostMapping
	public DivPolitica create(@RequestBody DivPolitica divPol) {
		return repository.save(divPol);
	}

	@GetMapping
	public List<DivPolitica> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public List<DivPolitica> divPoliticacountrylist(@PathVariable Integer id) {

		List<DivPolitica> divPoliticaBD = null;
		List<DivPolitica> listDivPolitica = new ArrayList<DivPolitica>();

		divPoliticaBD = repository.findAll();

		for (DivPolitica bd : divPoliticaBD) {
			if (bd.getCOUNTRY() == id) {
				listDivPolitica.add(bd);
			}
		}
		return listDivPolitica;
	}

	@GetMapping(path = "/name/{name}")
	public List<DivPolitica> findByNameLike(@PathVariable String name) {

		List<DivPolitica> politicaBD = null;
		List<DivPolitica> finalList = new ArrayList<DivPolitica>();

		politicaBD = repository.findAll();

		for (DivPolitica bd : politicaBD) {
			if (bd.getNAME().contains(name)) {
				finalList.add(bd);
			}
		}
		return finalList;
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
