package com.kp.martuls.validation;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kp.martuls.dao.repositorios.InvGrupoRepositorio;
import com.kp.martuls.dto.InvGrupoCreacionDto;

/**
 * 
 * InvGrupoValidador.java Validación de Grupos de Inventrario
 * 
 * @author Padilla
 *
 */

@Component
public class InvGrupoValidador 
{
	/**
	 * validador General
	 */
	@Autowired
	Validar validar;
	
	/**
	 * Repositorio InvGrupoRepositorio
	 */
	@Autowired
	InvGrupoRepositorio invGrupoRepositorio;
	
	
	/**
	 * Control De los parametros obligatorios  del objeto {@link InvGrupoCreacionDto}
	 * @param invGrupoCreacionDto objeto de entrada del servicio {@link InvGrupoCreacionDto}
	 * @throws RuntimeException retorna un codigo y un mensaje de error en el caso de faltar algún parametro
	 * obligatorio
	 */
	public void validarInvGrupoCreacionControlPresencia(InvGrupoCreacionDto invGrupoCreacionDto) 
			throws  RuntimeException
	{
		RuntimeException r =  null;
		
		
		// Validar codigo de Grupo no presente, null o vacia
		
		if (StringUtils.isBlank(invGrupoCreacionDto.getCodGrupo()))
		{
			r = new IllegalArgumentException(validar.getMsg0002() + " Grupo de Inventario");
		}
		
		// Validar Descripcion del GRupo de Inventario no presente, null o vacia
		
		else if (StringUtils.isBlank(invGrupoCreacionDto.getDescriGrupo()))
		{
			r = new IllegalArgumentException(validar.getMsg0003() + " Grupo de Inventario");
		}
		
		
		// si un error es detectado lanza el excepción 
		if (r != null)
		{
			throw r;
		}
		
		
	}
	
	/**
	 * Control de forma de los parametros de entrada del objeto {@link InvGrupoCreacionDto}
	 * @param invGrupoCreacionDto objeto de entrada del servicio {@link InvGrupoCreacionDto}
	 * @throws RuntimeException retorna un codigo y mensaje de error si la forma del parametro 
	 * no cumple con la las normas que se establezcan
	 */
	public void validarInvGrupoCreacionControlForma(InvGrupoCreacionDto invGrupoCreacionDto) 
			throws RuntimeException
	{
		
		// codigo de Grupo debe tener 6 caracteres		
		if (StringUtils.length(invGrupoCreacionDto.getCodGrupo()) != 6)
		{
			throw new IllegalArgumentException(validar.getMsg0007() + ",Codigo de Grupo permitido 6");
		}
		
		
		
	}
	
	/**
	 * Control de Fondo
	 * @param invGrupoCreacionDto
	 * @throws RuntimeException
	 */
	public void validarInvGrupoCreacionControlFondo(InvGrupoCreacionDto invGrupoCreacionDto) 
			throws RuntimeException
	{
		long countGrupo =invGrupoRepositorio.countByCodeGrupo(invGrupoCreacionDto.getCodGrupo());
		
		if (countGrupo > 0)
		{
			throw new IllegalArgumentException(validar.getMsg0008());
		}
		
		
		
	}
	

}
