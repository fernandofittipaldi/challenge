package com.disney.challenge.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.challenge.entities.Personaje;
import com.disney.challenge.repositories.PersonajeRepository;

@Service
public class PersonajeService {
	@Autowired
	private PersonajeRepository personajeRepository;
	
	public ArrayList<Personaje> obtenerPersonajes(){
		return (ArrayList<Personaje>) personajeRepository.findAll();
	}
	
	public Personaje guardarPersonaje(Personaje personaje) {
		return personajeRepository.save(personaje);
	}
	
	public Personaje buscarPorNombre(String nombre){
		return personajeRepository.findByNombre(nombre);
	}
	
	public Personaje buscarPorEdad(int edad){
		return personajeRepository.findByEdad(edad);
	}
	
	public Personaje buscarPorPeso(double peso){
		return personajeRepository.findByPeso(peso);
	}
		
	public boolean eliminarPersonaje(int id) {
		boolean resultado = false;
		
		try {
			personajeRepository.deleteById(id);;
			resultado = true; 
		} catch(Exception error) {
			resultado = false; 
		}
		
		return resultado; 
	}
}
