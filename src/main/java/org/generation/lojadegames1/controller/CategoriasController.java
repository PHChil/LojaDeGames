package org.generation.lojadegames1.controller;

import java.util.List;

import org.generation.lojadegames1.model.Categorias;
import org.generation.lojadegames1.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {
	@Autowired
	public CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> GetALL(){
		return ResponseEntity.ok(repository.findAll());
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categorias>> GetByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Categorias> Post(@RequestBody Categorias categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categorias> Put(@RequestBody Categorias categoria){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(categoria));
	}
	
	@DeleteMapping
	public void Delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
