/**
 * 
 */
package com.kp.martuls.services;

import com.kp.martuls.dto.InvGrupoCreacionDto;

/**
 * @author Padilla
 *
 */
public interface InvGrupoService 
{
	
	Long crearInvGrupo(InvGrupoCreacionDto invGrupoCreacionDto) throws RuntimeException;
}
