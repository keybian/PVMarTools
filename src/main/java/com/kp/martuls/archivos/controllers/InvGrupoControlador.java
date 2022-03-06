/**
 * 
 */
package com.kp.martuls.archivos.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kp.martuls.dto.InvGrupoCreacionDto;
import com.kp.martuls.services.InvGrupoService;
import com.kp.martuls.validation.InvGrupoValidador;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Padilla
 *
 */
@RestController
@Api(value = "Inv_Grupo", consumes = "application/json")
@RequestMapping("invgrupo")
public class InvGrupoControlador 
{
	private static final String URL_CREATION = "/invgrupo/{id-invgrupo}";
	
	@Autowired
	InvGrupoValidador invGrupoValidador;
	
	@Autowired
	InvGrupoService areaCriticaService;

	/** Servico para crear los grupos de inventario
	 * 
	 * @param invGrupoCreacionDto objeto para la creacion de un grupos de inventario
	 * @return url del grupo de inventario  Creado
	 * @throws Exepcion : retorna codigo y mensaje de error
	 * 
	 */
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Crear Grupos del Inventario", notes = "Crear Grupos del Inventario")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Grupo Inventario creada Satisfactoriamente"),
			@ApiResponse(code = 400, message = "Excepcion controlada, durante el proceso"),
			@ApiResponse(code = 500, message = "Excepcion Tecnica generada durante el proceso")})
	public ResponseEntity<Void> crearInvGrupo(@RequestBody InvGrupoCreacionDto invGrupoCreacionDto)
			throws RuntimeException
	{
		
		//Control de Presencia
		invGrupoValidador.validarInvGrupoCreacionControlPresencia(invGrupoCreacionDto);
		
		//Control de Forma
		
		invGrupoValidador.validarInvGrupoCreacionControlForma(invGrupoCreacionDto);
		
		
		//Control de Coherencia
		
		
		
		//Control de Fondo
		
		invGrupoValidador.validarInvGrupoCreacionControlFondo(invGrupoCreacionDto);
		
		
		
		Long idInvGrupo =areaCriticaService.crearInvGrupo(invGrupoCreacionDto);
		
	    URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
	    		 .path(URL_CREATION)
	    		 .buildAndExpand(idInvGrupo)
	    		 .toUri();
	     	return ResponseEntity.created(location).build();
	}
	
	
	
	

}
