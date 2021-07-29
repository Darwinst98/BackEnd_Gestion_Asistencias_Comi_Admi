package Comite.Administrativo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Comite.Administrativo.models.entities.Persona;

public interface IPersona extends JpaRepository<Persona, Integer>{

}
