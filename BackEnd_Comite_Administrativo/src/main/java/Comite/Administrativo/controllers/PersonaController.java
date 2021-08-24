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

import Comite.Administrativo.models.entities.Persona;
import Comite.Administrativo.models.service.implementations.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	PersonaService service;
	
	@PostMapping("/create-Persona")
	public ResponseEntity<?> create(@RequestBody Persona pe){
		try {
			service.save(pe);
			return ResponseEntity.status(HttpStatus.CREATED).body(pe);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Persona> pe = service.findById(id);
			if(pe.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada");
			}
			return ResponseEntity.ok(pe);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	//List
	@GetMapping("/list-Persona")
	public ResponseEntity<?> list() {
		try {
			List<Persona> pe = service.findAll();
			if(pe.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Personas registradas");
			}
			return ResponseEntity.ok(pe);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Persona pe){
		try {
			pe.setIdpersona(id);
			service.save(pe);
			return ResponseEntity.ok(pe);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			
		    Optional<Persona> pe = service.findById(id);
		    if(pe.isEmpty()) {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada");
		    }
			service.delete(id);
			return ResponseEntity.ok(pe);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
