package com.escala.proyecto.milkaforrich.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información del libro")
@Entity
@Table(name="libro")
public class Libro {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_libro")
	 private Integer idLibro;
	 
	 @Column(name="nombre", nullable=false,  length = 100)
	 private String nombre;
	 
	 @Column(name="descripcion",  length = 250)
	 private String descripcion;
	 
	 @Column(name="anio",  length = 250)
	 private Integer anio;

	 @ManyToOne
	 @JoinColumn(name = "autor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_libro_autor"))
	 private Autor autorId;
	 
	 @ManyToOne
	 @JoinColumn(name = "editorial_id", nullable = false, foreignKey = @ForeignKey(name = "FK_libro_editorial"))
	 private Editorial editorialId;

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Autor getAutorId() {
		return autorId;
	}

	public void setAutorId(Autor autorId) {
		this.autorId = autorId;
	}

	public Editorial getEditorialId() {
		return editorialId;
	}

	public void setEditorialId(Editorial editorialId) {
		this.editorialId = editorialId;
	}
	 
	 
	 
	 
	 

}
