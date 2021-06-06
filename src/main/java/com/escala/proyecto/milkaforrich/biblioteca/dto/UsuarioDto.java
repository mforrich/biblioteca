package com.escala.proyecto.milkaforrich.biblioteca.dto;

import java.util.List;

public class UsuarioDto {
	
	private Integer id;
	private String fullNombre;
	private List<PrestamoDto> misPrestamos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullNombre() {
		return fullNombre;
	}
	public void setFullNombre(String fullNombre) {
		this.fullNombre = fullNombre;
	}
	public List<PrestamoDto> getMisPrestamos() {
		return misPrestamos;
	}
	public void setMisPrestamos(List<PrestamoDto> misPrestamos) {
		this.misPrestamos = misPrestamos;
	}
	
	

}
