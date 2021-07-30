package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Comite.Administrativo.models.entities.Reunion;
import Comite.Administrativo.models.repositories.IReunion;
import Comite.Administrativo.models.service.interfaces.IReunionService;

@Service
public class ReunionService implements IReunionService{
	
	@Autowired
	IReunion repository;

	@Override
	public void save(Reunion reunion) {
		repository.save(reunion);
	}

	@Override
	public Optional<Reunion> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Reunion> findAll() {
		return (List<Reunion>) repository.findAll();
	}

}
