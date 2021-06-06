package com.escala.proyecto.milkaforrich.biblioteca.service.impl;

import com.escala.proyecto.milkaforrich.biblioteca.dto.PrestamoDto;
import com.escala.proyecto.milkaforrich.biblioteca.exception.ModelNotFoundException;
import com.escala.proyecto.milkaforrich.biblioteca.model.Prestamo;
import com.escala.proyecto.milkaforrich.biblioteca.model.Usuario;
import com.escala.proyecto.milkaforrich.biblioteca.repository.PrestamoRepository;
import com.escala.proyecto.milkaforrich.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    Logger logger =  Logger.getLogger(PrestamoServiceImpl.class.getName());

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public Prestamo findById(Integer id) throws Exception {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);
        if (!prestamoOptional.isPresent()){
            throw new ModelNotFoundException("Prestamo con código "+id +" no encontrado");
        }
        return prestamoOptional.get();
    }

    @Override
    public List<Prestamo> findAll() {
        return  prestamoRepository.findAll();
    }

    @Override
    public Prestamo save(Prestamo prestamo) {
        Set<ConstraintViolation<Prestamo>> violations = getListValidators(prestamo);
        for (ConstraintViolation<Prestamo> violation : violations) {
            logger.severe(violation.getMessage());
        }
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        prestamoRepository.save(prestamo);
        return prestamo;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);
        if (!prestamoOptional.isPresent()){
            throw new ModelNotFoundException("Prestamo con código "+id +" no encontrado");
        }
        prestamoRepository.deleteById(id);
        return true;
    }

    @Override
    public Set<ConstraintViolation<Prestamo>> getListValidators(Prestamo prestamo) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(prestamo);
    }

    @Override
    public List<PrestamoDto> findByLibro(Integer idLibro)  throws Exception {
        List<Prestamo> prestamos = prestamoRepository.findByLibro(idLibro);
        if (prestamos.isEmpty()){
            throw new ModelNotFoundException("Prestamo del libro "+idLibro +" no encontrado");
        }
        List<PrestamoDto> list = new ArrayList<>();
        prestamos.forEach(prestamo -> list.add(addPrestamo(prestamo)));
        return list;
    }

    private PrestamoDto addPrestamo(Prestamo prestamo) {
        return new PrestamoDto(prestamo.getLibroId().getNombre(), getFullName(prestamo.getUsuario()),
                prestamo.getLibroId().getAutorId().getSeudonimo(), prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion(), prestamo.getAtraso());
    }

    @Override
    public List<PrestamoDto> findByUsuario(Integer rut) throws Exception  {
        List<Prestamo> prestamos = prestamoRepository.findByUsuario(rut);
        if (prestamos.isEmpty()){
            throw new ModelNotFoundException("Prestamos del usuario "+rut +" no encontrado");
        }
        List<PrestamoDto> list = new ArrayList<>();
        prestamos.forEach(prestamo -> list.add(addPrestamo(prestamo)));
        return list;
    }


    public String getFullName(Usuario usuario) {
        String fullName = (usuario.getNombres()!=null ? usuario.getNombres() : "") + (usuario.getApellidos()!=null ? usuario.getApellidos() : "");
        return fullName.equals("")  ? fullName :  "N/A";
    }
}
