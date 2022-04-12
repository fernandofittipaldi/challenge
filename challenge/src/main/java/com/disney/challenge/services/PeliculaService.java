package com.disney.challenge.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.challenge.entities.Pelicula;
import com.disney.challenge.repositories.PeliculaRepository;


@Service
public class PeliculaService {
	@Autowired
	PeliculaRepository peliculaRepository;
	
	public ArrayList<Pelicula> obtenerPeliculas(){
		return (ArrayList<Pelicula>) peliculaRepository.findAll();
	}
	
	public Pelicula guardarPeliculas(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}
	
	public Pelicula buscarPorTitulo(String titulo){
		return peliculaRepository.findByTitulo(titulo);
	}
	
	public boolean eliminarPelicula(int id) {
		boolean resultado = false;
		
		try {
			peliculaRepository.deleteById(id);;
			resultado = true; 
		} catch(Exception error) {
			resultado = false; 
		}
		
		return resultado; 
	}

}
