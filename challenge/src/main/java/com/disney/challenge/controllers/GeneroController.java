package com.disney.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.challenge.entities.Genero;
import com.disney.challenge.services.GeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {
	@Autowired
	GeneroService generoService;
	
	@PostMapping()
	public Genero cargarGenero(@RequestBody Genero genero) {
		return generoService.cargarGenero(genero);
	}

}
