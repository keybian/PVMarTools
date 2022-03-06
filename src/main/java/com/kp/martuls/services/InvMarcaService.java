/**
 * 
 */
package com.kp.martuls.services;


import com.kp.martuls.dto.InvMarcaCreacionDto;

/**
 * @author Padilla
 *
 */
public interface InvMarcaService 
{
	
	Long crearInvMarca(InvMarcaCreacionDto invMarcaCreacionDto) throws RuntimeException;
}
