package com.escala.proyecto.milkaforrich.biblioteca.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información de los autores de los libros")
@Entity
@Table(name="autor")
public class Autor {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_autor")
	 private Integer idAutor;
	 
	 @Column(name = "nombre", nullable=false, length = 50)
	 private String nombre;
	 
	 @Column(name = "apellido",  nullable=false, length = 50)
	 private String apellido;

	 @Column(name = "seudonimo", length = 50)
	 private String seudonimo;
	 
	 public Integer getIdAutor() {
		return idAutor;
	}

	 public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	 public String getNombre() {
		return nombre;
	}

	 public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 public String getApellido() {
		return apellido;
	}

	 public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSeudonimo() {
		return seudonimo;
	}

	public void setSeudonimo(String seudonimo) {
		this.seudonimo = seudonimo;
	}
}
