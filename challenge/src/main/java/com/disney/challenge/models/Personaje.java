package com.disney.challenge.models;

//import java.util.ArrayList;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity

public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String imagen;
	@Getter
	@Setter
	private String nombre;
	@Getter
	@Setter
	private int edad;
	@Getter
	@Setter
	private double peso;
	@Getter
	@Setter
	private String historia;
	//@Getter
	//@Setter
	//private ArrayList<Pelicula> peliculas;

}