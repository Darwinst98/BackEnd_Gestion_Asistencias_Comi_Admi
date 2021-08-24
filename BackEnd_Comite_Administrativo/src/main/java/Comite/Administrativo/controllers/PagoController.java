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

import Comite.Administrativo.models.entities.Pago;
import Comite.Administrativo.models.service.implementations.PagoService;

@RestController
@RequestMapping("/pago")
public class PagoController {
	
	@Autowired
	PagoService service;
	
	@PostMapping("/create-Pago")
	public ResponseEntity<?> create(@RequestBody Pago p){
		try {
			service.save(p);
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Pago> p = service.findById(id);
			if(p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pago no encontrado");
			}
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	//List
	@GetMapping("/list-Pago")
	public ResponseEntity<?> list() {
		try {
			List<Pago> p = service.findAll();
			if(p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Pago registrado");
			}
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Pago p){
		try {
			p.setIdPago(id);
			service.save(p);
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id){
		try {
			
		    Optional<Pago> p = service.findById(id);
		    if(p.isEmpty()) {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pago no encontrada");
		    }
			service.delete(id);
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
