package Comite.Administrativo.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import Comite.Administrativo.models.entities.Asistencia;

public interface IAsistenciaService {
	
	public void save(Asistencia asistencia); //Guardar -> Create/Update
	public Optional<Asistencia> findById(Integer id); //Consultar -> Retrieve
	public void delete(Integer id); //Borrar -> Delete
	public List<Asistencia> findAll(); //Consultar en conjunto -> List

}
