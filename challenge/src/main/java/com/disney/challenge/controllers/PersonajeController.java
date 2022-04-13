package com.disney.challenge.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.challenge.entities.Personaje;
import com.disney.challenge.services.PersonajeService;


@RestController
@RequestMapping("/characters")
public class PersonajeController {
	@Autowired
	private PersonajeService personajeService; 
	
	@GetMapping()
	public ArrayList<Personaje> obtenerPersonajes(){
		return personajeService.obtenerPersonajes();
	}
	
	@PostMapping()
	public ResponseEntity<Personaje> guardarPersonaje(@RequestBody Personaje personaje) {
		//return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.guardarPersonaje(personaje));
		Personaje personajeNew = personajeService.guardarPersonaje(personaje);
		return ResponseEntity.ok(personajeNew);
		//personajeService.guardarPersonaje(personaje);
	}
	
	@GetMapping (path = "/{nombre}")
	public Optional<Personaje> buscarPersonajePorNombre(@PathVariable("nombre") String nombre){
		return Optional.ofNullable(this.personajeService.buscarPorNombre(nombre));
	}
	
	@GetMapping (path = "/characters/{peso}")
	public Optional<Personaje> buscarPersonajePorPeso(@PathVariable("peso") double peso){
		return Optional.ofNullable(this.personajeService.buscarPorPeso(peso));
	}
	
	@GetMapping (path = "/characters/{edad}")
	public Optional<Personaje> buscarPersonajePorEdad(@PathVariable("edad") int edad){
		return Optional.ofNullable(this.personajeService.buscarPorEdad(edad));
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
