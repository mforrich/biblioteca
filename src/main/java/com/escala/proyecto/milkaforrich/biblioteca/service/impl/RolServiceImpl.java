package com.escala.proyecto.milkaforrich.biblioteca.service.impl;

import com.escala.proyecto.milkaforrich.biblioteca.exception.ModelNotFoundException;
import com.escala.proyecto.milkaforrich.biblioteca.model.Rol;
import com.escala.proyecto.milkaforrich.biblioteca.repository.RolRepository;
import com.escala.proyecto.milkaforrich.biblioteca.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class RolServiceImpl implements RolService {

    Logger logger = Logger.getLogger(RolServiceImpl.class.getName());

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Rol findById(Integer id) throws Exception {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (!rolOptional.isPresent()){
            throw new ModelNotFoundException("El rol no se encuentra en la base de datos");
        }
        return rolOptional.get();
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol save(Rol rol) {
        Set<ConstraintViolation<Rol>> violations = getListValidators(rol);
        for (ConstraintViolation<Rol> violation : violations) {
            logger.severe(violation.getMessage());
        }
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        rolRepository.save(rol);
        return rol;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (!rolOptional.isPresent()){
            throw new ModelNotFoundException("El rol no se encuentra en la base de datos");
        }
        //aquí tb se debería validar que el rol no esté siendo utilizado
        rolRepository.deleteById(id);
        return true;
    }

    @Override
    public Set<ConstraintViolation<Rol>> getListValidators(Rol rol) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(rol);
    }
}
