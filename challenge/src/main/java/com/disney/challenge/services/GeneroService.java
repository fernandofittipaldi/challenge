package com.disney.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.challenge.entities.Genero;

import com.disney.challenge.repositories.GeneroRepository;


@Service
public class GeneroService {
	@Autowired
	private GeneroRepository generoRepository;

	public Genero cargarGenero(Genero genero) {
		return generoRepository.save(genero);
	}
	
}
