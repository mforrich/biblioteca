package com.escala.proyecto.milkaforrich.biblioteca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Rol disponible para la web")
@Entity
@Table(name="rol")
public class Rol {

	@Id
	private Integer idRol;
	 

	@Column(name="nombre_rol",  nullable = false)
	private String nombre;
	 

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	 
	 
}
