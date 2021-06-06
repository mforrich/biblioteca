package com.escala.proyecto.milkaforrich.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escala.proyecto.milkaforrich.biblioteca.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Usuario findByUsername(String username);
}
