package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Comite.Administrativo.models.entities.Directiva;
import Comite.Administrativo.models.repositories.IDirectiva;
import Comite.Administrativo.models.service.interfaces.IDirectivaService;

@Service
public class DirectivaService implements IDirectivaService{
	
	@Autowired
	IDirectiva repository;

	@Override
	public void save(Directiva directiva) {
		repository.save(directiva);
		
	}

	@Override
	public Optional<Directiva> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Directiva> findAll() {
		return (List<Directiva>) repository.findAll();
	}

}
