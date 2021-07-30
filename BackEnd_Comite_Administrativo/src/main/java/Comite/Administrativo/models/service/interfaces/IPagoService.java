package Comite.Administrativo.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import Comite.Administrativo.models.entities.Pago;

public interface IPagoService {
	
	public void save(Pago pago); //Guardar -> Create/Update
	public Optional<Pago> findById(Integer id); //Consultar -> Retrieve
	public void delete(Integer id); //Borrar -> Delete
	public List<Pago> findAll(); //Consultar en conjunto -> List

}
