package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Comite.Administrativo.models.entities.Persona;
import Comite.Administrativo.models.repositories.IPersona;
import Comite.Administrativo.models.service.interfaces.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	
	@Autowired
	IPersona repository;
	
	@Override
	public void save(Persona persona) {
		repository.save(persona);
	}

	@Override
	public Optional<Persona> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Persona> findAll() {
		return (List<Persona>) repository.findAll();
	}

}
