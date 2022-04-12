package com.disney.challenge.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.disney.challenge.entities.Genero;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Integer> {

}
