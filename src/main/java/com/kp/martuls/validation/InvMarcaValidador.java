package com.kp.martuls.validation;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kp.martuls.dao.repositorios.InvMarcaRepositorio;
import com.kp.martuls.dto.InvMarcaCreacionDto;

/**
 * 
 * InvGrupoValidador.java Validación de Grupos de Inventrario
 * 
 * @author Padilla
 *
 */

@Component
public class InvMarcaValidador 
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
	InvMarcaRepositorio invGrupoRepositorio;
	
	
	/**
	 * Control De los parametros obligatorios  del objeto {@link InvMarcaCreacionDto}
	 * @param invMarcaCreacionDto objeto de entrada del servicio {@link InvMarcaCreacionDto}
	 * @throws RuntimeException retorna un codigo y un mensaje de error en el caso de faltar algún parametro
	 * obligatorio
	 */
	public void validarInvMarcaCreacionControlPresencia(InvMarcaCreacionDto invMarcaCreacionDto) 
			throws  RuntimeException
	{
		RuntimeException r =  null;
		
		
		// Validar codigo de Marca no presente, null o vacia
		
		if (StringUtils.isBlank(invMarcaCreacionDto.getCodMarca()))
		{
			r = new IllegalArgumentException(validar.getMsg0002() + " Marca de Inventario");
		}
		
		// Validar Descripcion de la Marca de Inventario no presente, null o vacia
		
		else if (StringUtils.isBlank(invMarcaCreacionDto.getDescriMarca()))
		{
			r = new IllegalArgumentException(validar.getMsg0003() + "Descripcion Marca");
		}
		
		
		// si un error es detectado lanza el excepción 
		if (r != null)
		{
			throw r;
		}
		
		
	}
	
	/**
	 * Control de forma de los parametros de entrada del objeto {@link InvMarcaCreacionDto}
	 * @param invMarcaCreacionDto objeto de entrada del servicio {@link invMarcaCreacionDto}
	 * @throws RuntimeException retorna un codigo y mensaje de error si la forma del parametro 
	 * no cumple con la las normas que se establezcan
	 */
	public void validarInvMarcaCreacionControlForma(InvMarcaCreacionDto invMarcaCreacionDto) 
			throws RuntimeException
	{
		
		// codigo de Grupo debe tener 6 caracteres		
		if (StringUtils.length(invMarcaCreacionDto.getCodMarca()) != 6)
		{
			throw new IllegalArgumentException(validar.getMsg0007() + ",Codigo de Marca permitido 6");
		}
		
		
		
	}
	
	/**
	 * Control de Fondo
	 * @param invMarcaCreacionDto
	 * @throws RuntimeException
	 */
	public void validarInvMarcaCreacionControlFondo(InvMarcaCreacionDto invMarcaCreacionDto) 
			throws RuntimeException
	{
		long countGrupo =invGrupoRepositorio.countByCodeGrupo(invMarcaCreacionDto.getCodMarca());
		
		if (countGrupo > 0)
		{
			throw new IllegalArgumentException(validar.getMsg0008());
		}
		
		
		
	}
	

}
