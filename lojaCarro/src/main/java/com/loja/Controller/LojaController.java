package com.loja.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.model.Loja;
import com.loja.repository.LojaRepository;

@RestController //comente aqui
@RequestMapping("/loja")
public class LojaController {
	
	@Autowired //comente aqui
	private LojaRepository repository;
	
	@GetMapping //comente aqui
	public ResponseEntity<List<Loja>> retornandoString() {
		return ResponseEntity.ok(repository.findAll());	
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Loja> getById(@PathVariable int id) { //comente aqui
		Optional<Loja> lojaExist = repository.findById(id);
		
		if(lojaExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();			
			
			return ResponseEntity.ok(lojaExist.get());
		}
	
	@PostMapping //comenhte aqui
	public ResponseEntity<Loja> post(@RequestBody Loja loja) { //comente aqui
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
		
	}
	
	@PutMapping //comente aqui
	public ResponseEntity<Loja> put(@RequestBody Loja loja) {//comente aqui
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(loja));		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) { //comente aqui
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}