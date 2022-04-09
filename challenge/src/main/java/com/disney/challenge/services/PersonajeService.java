package com.disney.challenge.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.challenge.models.Personaje;
import com.disney.challenge.repositories.PersonajeRepository;

@Service
public class PersonajeService {
	@Autowired
	PersonajeRepository personajeRepository;
	
	public ArrayList<Personaje> obtenerPersonajes(){
		return (ArrayList<Personaje>) personajeRepository.findAll();
	}
	
	public void guardarPersonaje(Personaje personaje) {
		personajeRepository.save(personaje);
	}

}
