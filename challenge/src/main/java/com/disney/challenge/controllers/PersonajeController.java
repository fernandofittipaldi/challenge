package com.disney.challenge.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.challenge.models.Personaje;
import com.disney.challenge.services.PersonajeService;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
	@Autowired
	PersonajeService personajeService; 
	
	@GetMapping()
	public ArrayList<Personaje> obtenerPersonajes(){
		return personajeService.obtenerPersonajes();
	}
	
	@PostMapping("/guardar")
	public void guardarPersonaje(@RequestBody Personaje personaje) {
		personajeService.guardarPersonaje(personaje);
	}
	
}
