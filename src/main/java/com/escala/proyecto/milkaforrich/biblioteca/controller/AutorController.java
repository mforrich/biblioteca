package com.escala.proyecto.milkaforrich.biblioteca.controller;

import com.escala.proyecto.milkaforrich.biblioteca.model.Autor;
import com.escala.proyecto.milkaforrich.biblioteca.service.AutorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/autor")
public class AutorController {

    Logger logger = Logger.getLogger(AutorController.class.getName());

    @Autowired
    private AutorService autorService;

    @ApiOperation(value = "Regresa todos los autores que la biblioteca tenga")
    @GetMapping("/all")
    public List<Autor> findAll(){
        return autorService.findAll();
    }

    @ApiOperation(value = "Regresa al autor por su id")
    @GetMapping("/{id}")
    public Autor findById(@PathVariable Integer id) throws Exception{
        logger.info("EL id del autor es "+ id);
        return autorService.findById(id);
    }

    @ApiOperation(value = "Crea un nuevo autor")
    @PostMapping
    public Autor save(@RequestBody Autor autor) {
        logger.info("Estamos guardando un nuevo autor"+ autor);
        return autorService.save(autor);
    }

    @ApiOperation(value = "Actualiza un autor")
    @PutMapping
    public Autor update(@RequestBody Autor autor) {
        logger.info("Estamos actualizando un autor"+ autor);
        return autorService.save(autor);
    }

    @ApiOperation(value = "Elimina el autor mediante el id")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) throws Exception {
        logger.info("Estamos eliminando un  autor por id"+ id);
        autorService.deleteById(id);
        return "Autor eliminado permanente";
    }
}
