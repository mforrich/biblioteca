package com.escala.proyecto.milkaforrich.biblioteca.service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public interface GeneralService<E> {
	
    E findById(Integer id) throws Exception;
    List<E> findAll();
    E save(E e);
    boolean deleteById(Integer id) throws Exception;
    Set<ConstraintViolation<E>> getListValidators(E e);
}
