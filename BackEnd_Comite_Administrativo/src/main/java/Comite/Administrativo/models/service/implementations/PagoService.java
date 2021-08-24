package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Comite.Administrativo.models.entities.Pago;
import Comite.Administrativo.models.repositories.IPago;
import Comite.Administrativo.models.service.interfaces.IPagoService;

@Service
public class PagoService implements IPagoService{

	@Autowired
	IPago repository;
	
	@Override
	@Transactional
	public void save(Pago pago) {
		repository.save(pago);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Pago> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pago> findAll() {
		return (List<Pago>) repository.findAll();
	}

}
