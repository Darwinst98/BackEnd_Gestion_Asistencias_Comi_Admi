package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Comite.Administrativo.models.entities.Persona;
import Comite.Administrativo.models.repositories.IPersona;
import Comite.Administrativo.models.service.interfaces.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	
	@Autowired
	IPersona repository;
	
	@Override
	@Transactional
	public void save(Persona persona) {
		repository.save(persona);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Persona> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		return (List<Persona>) repository.findAll();
	}

}
