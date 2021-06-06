package com.escala.proyecto.milkaforrich.biblioteca.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import com.escala.proyecto.milkaforrich.biblioteca.exception.ModelNotFoundException;
import com.escala.proyecto.milkaforrich.biblioteca.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.escala.proyecto.milkaforrich.biblioteca.model.Usuario;
import com.escala.proyecto.milkaforrich.biblioteca.repository.UsuarioRepository;
import com.escala.proyecto.milkaforrich.biblioteca.service.UsuarioService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {
	Logger logger = Logger.getLogger(UsuarioServiceImpl.class.getName());

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario findById(Integer id) throws Exception {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (!usuarioOptional.isPresent()){
			throw new ModelNotFoundException("El usuaurio no existe");
		}
		return usuarioOptional.get();
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		Set<ConstraintViolation<Usuario>> violations = getListValidators(usuario);
		for (ConstraintViolation<Usuario> violation : violations) {
			logger.severe(violation.getMessage());
		}
		if(!violations.isEmpty()){
			throw new ConstraintViolationException(violations);
		}
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuarioRepository.save(usuario);
		return usuario;
	}


	@Override
	public boolean deleteById(Integer id) throws Exception {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (!usuarioOptional.isPresent()){
			throw new ModelNotFoundException("El usuaurio no existe");
		}
		usuarioRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<ConstraintViolation<Usuario>> getListValidators(Usuario usuario) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return validator.validate(usuario);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		usuario.getRols().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);
		return ud;
	}
}
