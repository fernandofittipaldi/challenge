package com.disney.challenge.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.disney.challenge.entities.Personaje;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Integer> {
	
	public abstract Personaje findByNombre(String nombre);
	
}
