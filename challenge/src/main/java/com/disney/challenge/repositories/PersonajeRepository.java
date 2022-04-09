package com.disney.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.challenge.models.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {

}
