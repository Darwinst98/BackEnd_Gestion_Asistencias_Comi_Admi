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

import Comite.Administrativo.models.entities.Reunion;
import Comite.Administrativo.models.service.implementations.ReunionService;

@RestController
@RequestMapping("/reunion")
public class ReunionController {
	
	@Autowired
	ReunionService service;
	
	@PostMapping("/create-reunion")
	public ResponseEntity<?> create(@RequestBody Reunion r){
		try {
			service.save(r);
			return ResponseEntity.status(HttpStatus.CREATED).body(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Reunion> r = service.findById(id);
			if(r.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reunion no encontrada");
			}
			return ResponseEntity.ok(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	//List
	@GetMapping("/list-Reunion")
	public ResponseEntity<?> list() {
		try {
			List<Reunion> r = service.findAll();
			if(r.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Reuniones registradas");
			}
			return ResponseEntity.ok(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Reunion r){
		try {
			r.setIdReunion(id);
			service.save(r);
			return ResponseEntity.ok(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			
		    Optional<Reunion> r = service.findById(id);
		    if(r.isEmpty()) {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reunion no encontrada");
		    }
			service.delete(id);
			return ResponseEntity.ok(r);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
