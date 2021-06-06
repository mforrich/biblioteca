package com.escala.proyecto.milkaforrich.biblioteca.dto;

import java.util.Date;

public class PrestamoDto {

	private String nombreLibro;
	private String nombreUsuario;
	private String nombreAutor;
	private Date desde;
	private Date hasta;
	private Boolean conMulta;
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	public Boolean getConMulta() {
		return conMulta;
	}
	public void setConMulta(Boolean conMulta) {
		this.conMulta = conMulta;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public PrestamoDto(String nombreLibro, String nombreUsuario, String nombreAutor, Date desde, Date hasta, Boolean conMulta) {
		this.nombreLibro = nombreLibro;
		this.nombreUsuario = nombreUsuario;
		this.nombreAutor = nombreAutor;
		this.desde = desde;
		this.hasta = hasta;
		this.conMulta = conMulta;
	}
}
