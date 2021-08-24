package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Comite.Administrativo.models.entities.Dignatario;
import Comite.Administrativo.models.repositories.IDignatario;
import Comite.Administrativo.models.service.interfaces.IDignatarioService;

@Service
public class DignatarioService implements IDignatarioService {
	
	//Sirve para implementar los metodos de gestión, inyectado en DAO

	@Autowired
	IDignatario repository; //<- DAO Data Access Objet
	
	@Override
	@Transactional
	public void save(Dignatario dignatario) {
		repository.save(dignatario);	
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Dignatario> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Dignatario> findAll() {
		return (List<Dignatario>) repository.findAll();
	}

}
