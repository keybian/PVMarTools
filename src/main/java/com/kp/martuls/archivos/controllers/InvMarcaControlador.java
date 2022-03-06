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

import com.kp.martuls.dto.InvMarcaCreacionDto;
import com.kp.martuls.services.InvMarcaService;
import com.kp.martuls.validation.InvMarcaValidador;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Padilla
 *
 */
@RestController
@Api(value = "Inv_Marca", consumes = "application/json")
@RequestMapping("invmarca")
public class InvMarcaControlador 
{
	private static final String URL_CREATION = "/invmarca/{id-invmarca}";
	
	@Autowired
	InvMarcaValidador invMarcaValidador;
	
	@Autowired
	InvMarcaService invMarcaService;

	/** Servico para crear las Marcas de inventario
	 * 
	 * @param invMarcaCreacionDto objeto para la creacion de Marcas de inventario
	 * @return url de la Marca de inventario  Creada
	 * @throws Exepcion : retorna codigo y mensaje de error
	 * 
	 */
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Crear Marcas del Inventario", notes = "Crear Marcas del Inventario")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Marca Inventario creada Satisfactoriamente"),
			@ApiResponse(code = 400, message = "Excepcion controlada, durante el proceso"),
			@ApiResponse(code = 500, message = "Excepcion Tecnica generada durante el proceso")})
	public ResponseEntity<Void> crearInvMarca(@RequestBody InvMarcaCreacionDto invMarcaCreacionDto)
			throws RuntimeException
	{
		
		//Control de Presencia
		invMarcaValidador.validarInvMarcaCreacionControlPresencia(invMarcaCreacionDto);
		
		//Control de Forma
		
		invMarcaValidador.validarInvMarcaCreacionControlForma(invMarcaCreacionDto);
		
		
		//Control de Coherencia
		
		
		
		//Control de Fondo
		
		invMarcaValidador.validarInvMarcaCreacionControlFondo(invMarcaCreacionDto);
		
		
		
		Long idInvMarca =invMarcaService.crearInvMarca(invMarcaCreacionDto);
		
	    URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
	    		 .path(URL_CREATION)
	    		 .buildAndExpand(idInvMarca)
	    		 .toUri();
	     	return ResponseEntity.created(location).build();
	}
	
	
	
	

}
