package com.escala.proyecto.milkaforrich.biblioteca.repository;

import com.escala.proyecto.milkaforrich.biblioteca.dto.PrestamoDto;
import com.escala.proyecto.milkaforrich.biblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{

    @Query("from Prestamo p INNER JOIN FETCH p.libroId l INNER JOIN FETCH p.usuario u where l.idLibro =:id")
    List<Prestamo> findByLibro(@Param("id")Integer id);

    @Query("from Prestamo p INNER JOIN FETCH p.libroId l INNER JOIN FETCH p.usuario u where u.rut =:rut")
    List<Prestamo> findByUsuario(@Param("rut")Integer rut);
}
