package Comite.Administrativo.models.repositories;

import org.springframework.data.repository.CrudRepository;

import Comite.Administrativo.models.entities.Directiva;
                                    
//Modelo-Entidad al que se quiere vincular la gestion 
//Parametro tipo de dato del atributo que representa la PK del modelo-entidad (clave primaria)
public interface IDirectiva extends CrudRepository<Directiva, Integer>{

	//Conocido como Data Access Object - DAD
}
