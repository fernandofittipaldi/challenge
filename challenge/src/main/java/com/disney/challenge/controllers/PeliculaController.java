package com.disney.challenge.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disney.challenge.entities.Pelicula;
import com.disney.challenge.services.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	@Autowired
	private PeliculaService peliculaService; 
	
	@GetMapping()
	public ArrayList<Pelicula> obtenerPeliculas(){
		return peliculaService.obtenerPeliculas();
	}
	
	@PostMapping()
	public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
		return peliculaService.guardarPeliculas(pelicula);
	}
	
	@GetMapping (path = "/movies/{titulo}")
	public Optional<Pelicula> obtenerPeliculasPorTitulo(@PathVariable("titulo") String titulo){
		return Optional.ofNullable(this.peliculaService.buscarPorTitulo(titulo));
	}
	
	@DeleteMapping (path = "/{id}")
	public String eliminarPeliculaPorId(@PathVariable("id") int id) {
		if (this.peliculaService.eliminarPelicula(id)) {
			return "Pelicula " + id + " ha sido eliminado.";
		} else {
			return "Pelicula " + id + " no encontrado.";
		}
	}
}
