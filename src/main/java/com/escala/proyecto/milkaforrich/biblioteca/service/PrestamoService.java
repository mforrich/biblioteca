package com.escala.proyecto.milkaforrich.biblioteca.service;

import com.escala.proyecto.milkaforrich.biblioteca.dto.PrestamoDto;
import com.escala.proyecto.milkaforrich.biblioteca.model.Prestamo;

import java.util.List;

public interface PrestamoService extends GeneralService<Prestamo> {

    List<PrestamoDto> findByLibro(Integer idLibro)  throws Exception ;
    List<PrestamoDto> findByUsuario(Integer rut)  throws Exception ;
}
