package org.generation.lojadegames1.controller;

import java.util.List;

import org.generation.lojadegames1.model.Jogos;
import org.generation.lojadegames1.repository.JogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogos")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class JogosController {
	@Autowired
	public JogosRepository repository;
	
	@GetMapping
	public ResponseEntity <List<Jogos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogos> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Jogos>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Jogos> Post(@RequestBody Jogos jogo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(jogo));
	}
	
	@PutMapping
	public ResponseEntity<Jogos> Put (@RequestBody Jogos jogo){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(jogo));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
