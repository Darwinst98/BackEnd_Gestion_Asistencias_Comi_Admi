package Comite.Administrativo.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Comite.Administrativo.models.entities.Pago;
import Comite.Administrativo.models.repositories.IPago;
import Comite.Administrativo.models.service.interfaces.IPagoService;

@Service
public class PagoService implements IPagoService{

	@Autowired
	IPago repository;
	
	@Override
	public void save(Pago pago) {
		repository.save(pago);
		
	}

	@Override
	public Optional<Pago> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Pago> findAll() {
		return (List<Pago>) repository.findAll();
	}

}
