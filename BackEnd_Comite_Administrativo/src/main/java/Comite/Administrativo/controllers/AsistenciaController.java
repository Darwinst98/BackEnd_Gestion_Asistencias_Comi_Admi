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

import Comite.Administrativo.models.service.implementations.AsistenciaService;
import Comite.Administrativo.models.entities.Asistencia;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
	
	@Autowired
	AsistenciaService service;
	
	@PostMapping("/create-Asistencia")
	public ResponseEntity<?> create(@RequestBody Asistencia a){
		try {
			service.save(a);
			return ResponseEntity.status(HttpStatus.CREATED).body(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Asistencia> a = service.findById(id);
			if(a.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asistencia no encontrada");
			}
			return ResponseEntity.ok(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	//List
	@GetMapping("/list-Asistencia")
	public ResponseEntity<?> list() {
		try {
			List<Asistencia> asist = service.findAll();
			if(asist.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Asistencias registradas");
			}
			return ResponseEntity.ok(asist);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Asistencia a){
		try {
			a.setIdAsistencia(id);
			service.save(a);
			return ResponseEntity.ok(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> update(@PathVariable Integer id){
			try {
				
			    Optional<Asistencia> a = service.findById(id);
			    if(a.isEmpty()) {
			    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asistecia no encontrada");
			    }
				service.delete(id);
				return ResponseEntity.ok(a);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}

}
