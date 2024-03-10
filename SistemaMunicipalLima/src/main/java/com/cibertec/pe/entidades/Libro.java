package com.cibertec.pe.entidades;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 4, max = 60)
    private String nombre;
    
    @NotBlank
    @Size(min = 4, max = 60)
    private String autor;
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private Date fechaPublicacion;
    
    @NotBlank
    private String genero;
    
    
    /* CONTRUCTORES*/
   
	public Libro() {
		super();
	}

	public Libro(Long id, @NotBlank @Size(min = 4, max = 60) String nombre,
			@NotBlank @Size(min = 4, max = 60) String autor, @NotNull Date fechaPublicacion, @NotBlank String genero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.genero = genero;
	}
	
	/* GETTERS AND SETTERS */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}