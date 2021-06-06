package com.escala.proyecto.milkaforrich.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escala.proyecto.milkaforrich.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
