package com.escala.proyecto.milkaforrich.biblioteca.controller;

import com.escala.proyecto.milkaforrich.biblioteca.dto.PrestamoDto;
import com.escala.proyecto.milkaforrich.biblioteca.model.Editorial;
import com.escala.proyecto.milkaforrich.biblioteca.model.Prestamo;
import com.escala.proyecto.milkaforrich.biblioteca.service.LibroService;
import com.escala.proyecto.milkaforrich.biblioteca.service.PrestamoService;
import com.escala.proyecto.milkaforrich.biblioteca.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    Logger logger =  Logger.getLogger(PrestamoController.class.getName());
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private LibroService libroService;
    @Autowired
    private PrestamoService prestamoService;

    @ApiOperation(value = "Obtener el listado de los prestamos de un libro en especifico ",
            notes = "Necesita el id del Libro a analizar",
            response = List.class,
            responseContainer = "PrestamoDto")
    @GetMapping("/byLibro/{idLibro}")
    public List<PrestamoDto> findPrestamosByLibro(@PathVariable Integer idLibro) throws Exception{
        return prestamoService.findByLibro(idLibro);

    }

    @ApiOperation(value = "Obtener los libros que usuario ha solitiado ",
            notes = "Necesita el id del Libro a analizar",
            response = List.class,
            responseContainer = "PrestamoDto")
    @GetMapping("/byRut/{rut}")
    public List<PrestamoDto> findPrestamosByRut(@PathVariable Integer rut) throws Exception{
        return null;

    }

    @GetMapping("/all")
    public List<Prestamo> findAll() {
        return prestamoService.findAll();
    }

    @ApiOperation(value = "Obtener el prestamo por id",
            notes = "Id de la editorial que se busca",
            response = Prestamo.class,
            responseContainer = "Editorial")
    @GetMapping("/{id}")
    public Prestamo findById(@PathVariable("id") Integer id) throws Exception {
        return prestamoService.findById(id);
    }

    @ApiOperation(value = "Guarda el prestamo",
            notes = "Requiere los datos del usuario y libro de manera obligatoria",
            response = Prestamo.class,
            responseContainer = "Prestamo")
    @PostMapping
    public Prestamo save(@RequestBody Prestamo prestamo){
        return prestamoService.save(prestamo);
    }

    @ApiOperation(value = "Actualiza los datos de un prestamo",
            notes = "Se necesita idPrestamo y la fecha de prestamo",
            response = Prestamo.class,
            responseContainer = "Editorial")
    @PutMapping
    public Prestamo update(@RequestBody Prestamo prestamo){
        logger.info("Prestamo "+prestamo.getIdPrestamo());
        return prestamoService.save(prestamo);
    }

    @ApiOperation(value = "Elimina el prestamo del sistema",
            notes = "Id del prestamo que se busca eliminar",
            response = Prestamo.class,
            responseContainer = "Prestamo")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        prestamoService.deleteById(id);
        return "Se ha eliminado de manera exitosa";
    }
}
