package Comite.Administrativo.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import Comite.Administrativo.models.entities.Dignatario;

public interface IDignatarioService {
	
	/*La interface del servicio, sirve para definir el conjunto de métodos que
	 se van a implemetar para la Gestión del modelo-entidad*/
	
	public void save(Dignatario dignatario); //Guardar -> Create/Update
	public Optional<Dignatario> findById(Integer id); //Consultar -> Retrieve
	public void delete(Integer id); //Borrar -> Delete
	public List<Dignatario> findAll(); //Consultar en conjunto -> List

}
