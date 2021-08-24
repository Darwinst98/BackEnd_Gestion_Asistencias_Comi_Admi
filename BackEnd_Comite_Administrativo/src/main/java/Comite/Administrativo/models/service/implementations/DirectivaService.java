package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Comite.Administrativo.models.entities.Dignatario;
import Comite.Administrativo.models.entities.Directiva;
import Comite.Administrativo.models.repositories.IDignatario;
import Comite.Administrativo.models.repositories.IDirectiva;
import Comite.Administrativo.models.service.interfaces.IDirectivaService;

@Service
public class DirectivaService implements IDirectivaService{
	
	@Autowired
	IDirectiva repository;
	
	@Autowired
	IDignatario repositoryDignatario;
	 
	@Override
	@Transactional
	public void save(Directiva directiva) {
		repository.save(directiva);
		for(Dignatario  d : directiva.getEncargado()) {
				d.setDirectiva(directiva);
				repositoryDignatario.save(d);
				
			}	
	}


	@Transactional(readOnly=true)
	@Override
	public Optional<Directiva> findById(Integer id) {
		return repository.findById(id);
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Directiva> findAll() {
		return (List<Directiva>) repository.findAll();
	}

}
