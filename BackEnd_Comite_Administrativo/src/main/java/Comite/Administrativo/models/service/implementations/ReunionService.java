package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Comite.Administrativo.models.entities.Reunion;
import Comite.Administrativo.models.entities.Asistencia;
import Comite.Administrativo.models.repositories.IReunion;
import Comite.Administrativo.models.repositories.IAsistencia;
import Comite.Administrativo.models.service.interfaces.IReunionService;

@Service
public class ReunionService implements IReunionService{
	
	@Autowired
	IReunion repository;

	@Autowired
	IAsistencia repositoryAsistencia;
	@Override
	@Transactional
	public void save(Reunion reunion) {
		repository.save(reunion);
		for(Asistencia  a : reunion.getAsistencias()) {
				a.setReuniones(reunion);
				repositoryAsistencia.save(a);
				
			}	
	}
	

	@Transactional(readOnly=true)
	@Override
	public Optional<Reunion> findById(Integer id) {
		return repository.findById(id);
	}

	
	@Transactional
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	
	@Transactional(readOnly=true)
	@Override
	public List<Reunion> findAll() {
		return (List<Reunion>) repository.findAll();
	}

}
