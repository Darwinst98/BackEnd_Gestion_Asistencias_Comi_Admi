package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Comite.Administrativo.models.entities.Asistencia;
import Comite.Administrativo.models.repositories.IAsistencia;
import Comite.Administrativo.models.service.interfaces.IAsistenciaService;

@Service
public class AsistenciaService implements IAsistenciaService {
	
	@Autowired
	IAsistencia repository;
	
	@Override
	@Transactional
	public void save(Asistencia asistencia) {
		repository.save(asistencia);	
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Asistencia> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asistencia> findAll() {
		return (List<Asistencia>) repository.findAll();
	}

}
