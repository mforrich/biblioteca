package com.escala.proyecto.milkaforrich.biblioteca.controller;

import com.escala.proyecto.milkaforrich.biblioteca.model.Rol;
import com.escala.proyecto.milkaforrich.biblioteca.service.RolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rol")
public class RolController {

    Logger logger = Logger.getLogger(RolController.class.getName());

    @Autowired
    private RolService rolService;


    @ApiOperation(value = "Regresa todos los roles del sistema")
    @GetMapping("/all")
    public List<Rol> findAll(){
        return rolService.findAll();
    }

    @ApiOperation(value = "Regresa el rol por id")
    @GetMapping("/{rut}")
    public Rol findById(@PathVariable Integer id) throws Exception{
        logger.info("EL id del rol es "+ id);
        return rolService.findById(id);
    }

    @ApiOperation(value = "Crea un nuevo rol")
    @PostMapping
    public Rol save(@RequestBody Rol rol) {
        logger.info("Estamos guardando un nuevo rol");
        return rolService.save(rol);
    }

    @ApiOperation(value = "Actualiza un rol")
    @PutMapping
    public Rol update(@RequestBody Rol rol) {
        logger.info("Estamos actualizando un rol");
        return rolService.save(rol);
    }

    @ApiOperation(value = "Elimina el usuario mediante el id")
    @DeleteMapping("/{rut}")
    public String delete(@PathVariable Integer rol) throws Exception {
        logger.info("Estamos eliminando un rol por id"+ rol);
        rolService.deleteById(rol);
        return "Rol eliminado correctamente";
    }
}
