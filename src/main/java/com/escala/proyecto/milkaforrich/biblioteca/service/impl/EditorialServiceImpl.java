package com.escala.proyecto.milkaforrich.biblioteca.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import com.escala.proyecto.milkaforrich.biblioteca.controller.EditorialController;
import com.escala.proyecto.milkaforrich.biblioteca.exception.ModelNotFoundException;
import com.escala.proyecto.milkaforrich.biblioteca.model.Editorial;
import com.escala.proyecto.milkaforrich.biblioteca.repository.*;
import com.escala.proyecto.milkaforrich.biblioteca.service.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EditorialServiceImpl implements EditorialService {

	Logger logger = Logger.getLogger(EditorialServiceImpl.class.getName());

	@Autowired
	private EditorialRepository editorialRepository;

	@Override
	public Editorial findById(Integer id) throws Exception {
		Optional<Editorial> optionalEditorial = editorialRepository.findById(id);
		if(!optionalEditorial.isPresent()){
			throw new ModelNotFoundException("Editorial con id : " + id+" No existe");
		}
		return optionalEditorial.get();
	}

	@Override
	public List<Editorial> findAll() {
		return editorialRepository.findAll();
	}

	@Override
	public Editorial save(Editorial editorial) {
		Set<ConstraintViolation<Editorial>> violations = getListValidators(editorial);
		for (ConstraintViolation<Editorial> violation : violations) {
			logger.severe(violation.getMessage());
		}
		if(!violations.isEmpty()){
	            throw new ConstraintViolationException(violations);
		}
		editorialRepository.save(editorial);
		return editorial;
	}



	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Editorial> optionalPaciente = editorialRepository.findById(id);
		if(!optionalPaciente.isPresent()){
			throw new ModelNotFoundException("Editorial con id : " + id+" No existe");
		}
		editorialRepository.deleteById(id);
		return true;

	}

	@Override
	public Set<ConstraintViolation<Editorial>> getListValidators(Editorial editorial) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return validator.validate(editorial);
	}


}
