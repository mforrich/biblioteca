package com.escala.proyecto.milkaforrich.biblioteca.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de un usuario * Información sensible")
@Entity
@Table(name="usuario")
public class Usuario {

	 @Id
	 @ApiModelProperty(notes = "El rut solo debe contener el dato número y sin digito verificador")
	 @Column(name = "rut", length = 9)
	 private Integer rut;
	 
	 @Column(name ="dv", length = 1, nullable=false)
	 private String dv;
	 
	 @Column(name="nombre_completo")
	 private String nombres;
	 
	 @Column(name="apellidos")
	 private String apellidos;
	 
	 @Email
	 @Column(name="email", nullable = false, unique = true)
	 private String email;

	 @Column(name="telefono")
	 private String telefono;

	 @Column(name = "password", nullable = false)
	 private String password;

	 @Column(name = "username",  nullable = false, unique = true)
	 private String username;

	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(
	      name = "usuario_rol",
	      joinColumns = @JoinColumn(name = "rut", referencedColumnName = "rut", foreignKey = @ForeignKey(name = "FK_usuario_rol_usuario")),
	      inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol",  foreignKey = @ForeignKey(name = "FK_usuario_rol_rol")))
	  private List<Rol> rols;

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Rol> getRols() {
		return rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
