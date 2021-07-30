package Comite.Administrativo.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import Comite.Administrativo.models.entities.Persona;

public interface IPersonaService {
	
	public void save(Persona persona); //Guardar -> Create/Update
	public Optional<Persona> findById(Integer id); //Consultar -> Retrieve
	public void delete(Integer id); //Borrar -> Delete
	public List<Persona> findAll(); //Consultar en conjunto -> List

}
