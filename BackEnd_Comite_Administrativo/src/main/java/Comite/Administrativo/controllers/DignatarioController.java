package Comite.Administrativo.controllers;

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

import Comite.Administrativo.models.entities.Dignatario;
import Comite.Administrativo.models.service.implementations.DignatarioService;

@RestController
@RequestMapping("/dignatario")
public class DignatarioController {
	
	@Autowired
	DignatarioService service;
	
	@PostMapping("/create-Dignatario")
	public ResponseEntity<?> create(@RequestBody Dignatario d){
		try {
			service.save(d);
			return ResponseEntity.status(HttpStatus.CREATED).body(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Dignatario> d = service.findById(id);
			if(d.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dignatario no encontrado");
			}
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	//List
	@GetMapping("/list-Dignatario")
	public ResponseEntity<?> list() {
		try {
			List<Dignatario> dig = service.findAll();
			if(dig.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Dignatarios registrados");
			}
			return ResponseEntity.ok(dig);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Dignatario d){
		try {
			d.setIdDignatario(id);
			service.save(d);
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			
		    Optional<Dignatario> d = service.findById(id);
		    if(d.isEmpty()) {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dignatario no encontrado");
		    }
			service.delete(id);
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
