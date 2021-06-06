package com.escala.proyecto.milkaforrich.biblioteca.controller;

import com.escala.proyecto.milkaforrich.biblioteca.model.Libro;
import com.escala.proyecto.milkaforrich.biblioteca.service.LibroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/libro")
public class LibroController {

    Logger logger = Logger.getLogger(LibroController.class.getName());

    @Autowired
    private LibroService libroService;

    @ApiOperation(value = "Guarda un nuevo libro")
    @PostMapping
    public Libro save(@RequestBody Libro libro){
        logger.info("Estamos guardando un libro nuevo");
        return libroService.save(libro);
    }

    @ApiOperation(value = "Busca un libro por id")
    @GetMapping("/{id}")
    public Libro findById(@PathVariable Integer id) throws Exception{
        return libroService.findById(id);
    }

    @ApiOperation(value ="Busca todos los libros")
    @GetMapping("/all")
    public List<Libro> findAll(){
        return libroService.findAll();
    }

    @ApiOperation(value = "Actualiza la información de un libro por id")
    @PutMapping
    public Libro update(@RequestBody Libro libro){
        return libroService.save(libro);
    }

    @ApiOperation(value = "Elimina un libro por id")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) throws Exception{
        libroService.deleteById(id);
        return "El libro ha sido eliminado de manera exitosa";
    }

}
