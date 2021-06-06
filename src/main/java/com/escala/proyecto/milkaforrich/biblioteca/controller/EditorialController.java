package com.escala.proyecto.milkaforrich.biblioteca.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.escala.proyecto.milkaforrich.biblioteca.model.Editorial;
import com.escala.proyecto.milkaforrich.biblioteca.service.EditorialService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/editorial")
public class EditorialController {
	Logger logger = Logger.getLogger(EditorialController.class.getName());

	@Autowired
	private EditorialService editorialService;
	
	@ApiOperation(value = "Obtener todos las editoriales que tiene la biblioteca",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Editorial")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pacientes en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
	
	@GetMapping("/all")
	public List<Editorial> findAll() {
		return editorialService.findAll();
	}

	@ApiOperation(value = "Obtener la editorial por id",
			notes = "Id de la editorial que se busca",
			response = Editorial.class,
			responseContainer = "Editorial")
	@GetMapping("/{id}")
	public Editorial findById(@PathVariable("id") Integer id) throws Exception {
		return editorialService.findById(id);
	}

	@ApiOperation(value = "Guarda la editorial",
			notes = "Requiere el nombre de la editorial",
			response = Editorial.class,
			responseContainer = "Editorial")
	@PostMapping
	public Editorial save(@RequestBody Editorial editorial){
	        return editorialService.save(editorial);
	    }

	@ApiOperation(value = "Actualiza el nombre de la editorial",
			notes = "Se necesita idEditorial y nombre",
			response = Editorial.class,
			responseContainer = "Editorial")
	@PutMapping
	public Editorial update(@RequestBody Editorial editorial){
		logger.info("Editorial "+editorial.getIdEditorial());
		return editorialService.save(editorial);
	}

	@ApiOperation(value = "Elimina la editorial del sistema",
			notes = "Id de la editorial que se busca eliminar",
			response = Editorial.class,
			responseContainer = "Editorial")
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Integer id) throws Exception {
		editorialService.deleteById(id);
		return "Editorial eliminada permanente";
	}


}
