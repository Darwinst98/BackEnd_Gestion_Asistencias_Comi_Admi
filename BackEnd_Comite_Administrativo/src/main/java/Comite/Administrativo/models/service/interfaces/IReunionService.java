package Comite.Administrativo.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import Comite.Administrativo.models.entities.Reunion;

public interface IReunionService {
	
	public void save(Reunion reunion); //Guardar -> Create/Update
	public Optional<Reunion> findById(Integer id); //Consultar -> Retrieve
	public void delete(Integer id); //Borrar -> Delete
	public List<Reunion> findAll(); //Consultar en conjunto -> List

}
