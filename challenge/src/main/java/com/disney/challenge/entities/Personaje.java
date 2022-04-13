package com.disney.challenge.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idPersonaje;
	
	private String imagen;
	
	private String nombre;
	
	private int edad;
	
	private double peso;
	
	private String historia;
		
	@JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PersonajePelicula",
    joinColumns = {
            @JoinColumn(name = "idPersonaje", nullable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "idPelicula", nullable = false)})
    private List<Pelicula> peliculasID;

	public List<Pelicula> getPeliculasID() {
		return peliculasID;
	}

	public void setPeliculasID(List<Pelicula> peliculasID) {
		this.peliculasID = peliculasID;
	}

	public Integer getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(Integer idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
	

}