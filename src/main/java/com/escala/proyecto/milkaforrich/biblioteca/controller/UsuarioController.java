package com.escala.proyecto.milkaforrich.biblioteca.controller;

import com.escala.proyecto.milkaforrich.biblioteca.model.Usuario;
import com.escala.proyecto.milkaforrich.biblioteca.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    Logger logger = Logger.getLogger(UsuarioController.class.getName());

    @Autowired
    private UsuarioService usuarioService;


    @ApiOperation(value = "Regresa todos los usuarios que la biblioteca tenga")
    @GetMapping("/all")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @ApiOperation(value = "Regresa al usuario por su rut")
    @GetMapping("/{rut}")
    public Usuario findById(@PathVariable Integer rut) throws Exception{
        logger.info("EL rut del usuario es "+ rut);
        return usuarioService.findById(rut);
    }

    @ApiOperation(value = "Crea un nuevo usuario")
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        logger.info("Estamos guardando un nuevo usuario");
        return usuarioService.save(usuario);
    }

    @ApiOperation(value = "Actualiza un usuario")
    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        logger.info("Estamos actualizando un usuario");
        return usuarioService.save(usuario);
    }

    @ApiOperation(value = "Elimina el usuario mediante el id")
    @DeleteMapping("/{rut}")
    public String delete(@PathVariable Integer rut) throws Exception {
        logger.info("Estamos eliminando un  usuario por rut"+ rut);
        usuarioService.deleteById(rut);
        return "Usuario eliminado correctamente";
    }
}
