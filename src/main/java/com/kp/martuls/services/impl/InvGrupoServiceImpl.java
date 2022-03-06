/**
 * 
 */
package com.kp.martuls.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.martuls.dao.entitys.InvGrupo;
import com.kp.martuls.dao.repositorios.InvGrupoRepositorio;
import com.kp.martuls.dto.InvGrupoCreacionDto;
import com.kp.martuls.services.InvGrupoService;
import com.kp.martuls.validation.Validar;

/**
 * @author Padilla
 *
 */
@Service
public class InvGrupoServiceImpl implements InvGrupoService
{
	@Autowired
	Validar validar;
	
	@Autowired
	InvGrupoRepositorio invGrupoRepositorio;

	@Override
	public Long crearInvGrupo(InvGrupoCreacionDto invGrupoCreacionDto) throws RuntimeException {
		// TODO Auto-generated method stub
		InvGrupo  gruposave = InvGrupo.builder()
				.codGrupo(invGrupoCreacionDto.getCodGrupo())
				.descriGrupo(invGrupoCreacionDto.getDescriGrupo())
				.status('A')
				.build();
		invGrupoRepositorio.save(gruposave);
		return gruposave.getIdGrupo();
	}
	
	

}
