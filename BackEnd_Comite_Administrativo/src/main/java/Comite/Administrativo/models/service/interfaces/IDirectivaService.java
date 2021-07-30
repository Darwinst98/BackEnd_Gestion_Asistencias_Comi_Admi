package Comite.Administrativo.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import Comite.Administrativo.models.entities.Directiva;

public interface IDirectivaService {
	
	public void save(Directiva directiva); //Guardar -> Create/Update
	public Optional<Directiva> findById(Integer id); //Consultar -> Retrieve
	public void delete(Integer id); //Borrar -> Delete
	public List<Directiva> findAll(); //Consultar en conjunto -> List

}
