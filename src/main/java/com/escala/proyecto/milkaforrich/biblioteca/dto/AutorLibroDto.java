package com.escala.proyecto.milkaforrich.biblioteca.dto;

import java.util.List;

import com.escala.proyecto.milkaforrich.biblioteca.model.Autor;

public class AutorLibroDto {
	
	private Autor autor;
	private List<LibroDto> libros;
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<LibroDto> getLibros() {
		return libros;
	}
	public void setLibros(List<LibroDto> libros) {
		this.libros = libros;
	}

	
}
