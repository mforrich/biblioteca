package com.escala.proyecto.milkaforrich.biblioteca.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import com.escala.proyecto.milkaforrich.biblioteca.exception.ModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escala.proyecto.milkaforrich.biblioteca.model.Libro;
import com.escala.proyecto.milkaforrich.biblioteca.repository.LibroRepository;
import com.escala.proyecto.milkaforrich.biblioteca.service.LibroService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class LibroServiceImpl implements LibroService {
	Logger logger = Logger.getLogger(LibroServiceImpl.class.getName());

	@Autowired
	private LibroRepository librorRepository;
	
	@Override
	public Libro findById(Integer id) throws Exception {
		Optional<Libro> libroOptional = librorRepository.findById(id);
		if (!libroOptional.isPresent()){
			throw new ModelNotFoundException("Libro con id "+id +" no encontrado");
		}
		return libroOptional.get();
	}

	@Override
	public List<Libro> findAll() {
		return librorRepository.findAll();
	}

	@Override
	public Libro save(Libro libro) {
		Set<ConstraintViolation<Libro>> violations = getListValidators(libro);
		for (ConstraintViolation<Libro> violation : violations) {
			logger.severe(violation.getMessage());
		}
		if(!violations.isEmpty()){
			throw new ConstraintViolationException(violations);
		}
		librorRepository.save(libro);
		return libro;
	}


	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Libro> libroOptional = librorRepository.findById(id);
		if (!libroOptional.isPresent()){
			throw new ModelNotFoundException("Libro con id "+ id +" No encontrado");
		}
		librorRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<ConstraintViolation<Libro>> getListValidators(Libro libro) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return validator.validate(libro);
	}


}
