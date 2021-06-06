package com.escala.proyecto.milkaforrich.biblioteca.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import com.escala.proyecto.milkaforrich.biblioteca.controller.EditorialController;
import com.escala.proyecto.milkaforrich.biblioteca.exception.ModelNotFoundException;
import com.escala.proyecto.milkaforrich.biblioteca.model.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escala.proyecto.milkaforrich.biblioteca.model.Autor;
import com.escala.proyecto.milkaforrich.biblioteca.repository.AutorRepository;
import com.escala.proyecto.milkaforrich.biblioteca.service.AutorService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class AutorServiceImpl implements AutorService {
	Logger logger = Logger.getLogger(AutorServiceImpl.class.getName());

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public Autor findById(Integer id) throws Exception {
		Optional<Autor> optionalAutor = autorRepository.findById(id);
		if (!optionalAutor.isPresent()){
			throw new ModelNotFoundException("Autor con id "+id+" no existe");
		}
		return optionalAutor.get();
	}

	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Autor> optionalAutor = autorRepository.findById(id);
		if (!optionalAutor.isPresent()){
			throw new ModelNotFoundException("Autor con id "+id+" no existe");
		}
		autorRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<ConstraintViolation<Autor>> getListValidators(Autor autor) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return validator.validate(autor);
	}

	@Override
	public Autor save(Autor autor) {
		Set<ConstraintViolation<Autor>> violations = getListValidators(autor);
		for (ConstraintViolation<Autor> violation : violations) {
			logger.severe(violation.getMessage());
		}
		if(!violations.isEmpty()){
			throw new ConstraintViolationException(violations);
		}
		autorRepository.save(autor);
		return autor;
	}


}
