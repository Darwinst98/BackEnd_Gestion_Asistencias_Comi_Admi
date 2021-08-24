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

import Comite.Administrativo.models.entities.Directiva;
import Comite.Administrativo.models.service.implementations.DirectivaService;

@RestController
@RequestMapping("/directiva")
public class DirectivaController {
	
	@Autowired
	DirectivaService service;
	
	@PostMapping("/create-Directiva")
	public ResponseEntity<?> create(@RequestBody Directiva di){
		try {
			service.save(di);
			return ResponseEntity.status(HttpStatus.CREATED).body(di);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Directiva> di = service.findById(id);
			if(di.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Directiva no encontrada");
			}
			return ResponseEntity.ok(di);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	//List
	@GetMapping("/list-Directiva")
	public ResponseEntity<?> list() {
		try {
			List<Directiva> dir = service.findAll();
			if(dir.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Directiva registrada");
			}
			return ResponseEntity.ok(dir);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Directiva dir){
		try {
			dir.setIdDirectiva(id);
			service.save(dir);
			return ResponseEntity.ok(dir);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			
		    Optional<Directiva> dir = service.findById(id);
		    if(dir.isEmpty()) {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Directiva no encontrada");
		    }
			service.delete(id);
			return ResponseEntity.ok(dir);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
