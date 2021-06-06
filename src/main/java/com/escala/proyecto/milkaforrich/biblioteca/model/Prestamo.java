package com.escala.proyecto.milkaforrich.biblioteca.model;

import java.util.Date;

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

@ApiModel(description = "Información de los libros prestados a un usuario")
@Entity
@Table(name="prestamo")
public class Prestamo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_prestamo")
	 private Integer idPrestamo;
	 
	 @ManyToOne
	 @JoinColumn(name = "libro_id", nullable = false, foreignKey = @ForeignKey(name = "FK_prestamo_libro"))
	 private Libro libroId;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_rut", nullable = false, foreignKey = @ForeignKey(name = "FK_prestamo_usuario"))
	 private Usuario usuario;
	 
	 @Column(name = "fecha_prestamo", nullable= false)
	 private Date fechaPrestamo;
	 
	 @Column(name ="fecha_devolucion", nullable= false)
	 private Date fechaDevolucion;
	 
	 @Column(name = "atraso", columnDefinition = "boolean default false",  nullable= false)
	 private Boolean atraso;

	public Integer getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Boolean getAtraso() {
		return atraso;
	}

	public void setAtraso(Boolean atraso) {
		this.atraso = atraso;
	}

	public Libro getLibroId() {
		return libroId;
	}

	public void setLibroId(Libro libroId) {
		this.libroId = libroId;
	}
	 
	
	
	 
	 
	 
	 
	 

}
