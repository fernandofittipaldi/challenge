package com.disney.challenge.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.challenge.entities.Personaje;
import com.disney.challenge.repositories.PersonajeRepository;
import com.disney.challenge.services.PersonajeService;

import antlr.collections.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
	@Autowired
	PersonajeService personajeService; 
	
	@GetMapping()
	public ArrayList<Personaje> obtenerPersonajes(){
		return personajeService.obtenerPersonajes();
	}
	
	@PostMapping()
	public Personaje guardarPersonaje(@RequestBody Personaje personaje) {
		return personajeService.guardarPersonaje(personaje);
	}
	
	@GetMapping (path = "/characters/{nombre}")
	public Optional<Personaje> obtenerPersonajePorNombre(@PathVariable("nombre") String nombre){
		return Optional.ofNullable(this.personajeService.buscarPorNombre(nombre));
	}
	
	@DeleteMapping (path = "/{id}")
	public String eliminarPersonajePorId(@PathVariable("id") int id) {
		if (this.personajeService.eliminarPersonaje(id)) {
			return "Personaje " + id + " ha sido eliminado.";
		} else {
			return "Personaje " + id + " no encontrado.";
		}
	}
	
	
}
