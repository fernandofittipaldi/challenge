package com.disney.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.disney.challenge.entities.Pelicula;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
	
	public abstract Pelicula findByTitulo(String nombre);

}
