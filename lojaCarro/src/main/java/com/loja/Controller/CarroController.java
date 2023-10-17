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

import com.loja.model.Carro;
import com.loja.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired // comente aqui
	private CarroRepository repository;

	@GetMapping
	public ResponseEntity<List<Carro>> get() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> getById(@PathVariable int id) { // comente aqui
		Optional<Carro> carroExist = repository.findById(id);

		if (carroExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		return ResponseEntity.ok(carroExist.get());
	}

	@PostMapping // comente aqui
	public ResponseEntity<Carro> post(@RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carro));
	}

	@PutMapping // comente aqui
	public ResponseEntity<Carro> put(@RequestBody Carro carro) { // comente aqui
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(carro));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) { // comente aqui
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}