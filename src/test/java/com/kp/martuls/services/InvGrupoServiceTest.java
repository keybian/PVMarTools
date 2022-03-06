package com.kp.martuls.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kp.martuls.dao.entitys.InvGrupo;
import com.kp.martuls.dao.repositorios.InvGrupoRepositorio;
import com.kp.martuls.dto.InvGrupoCreacionDto;
import com.kp.martuls.services.impl.InvGrupoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class InvGrupoServiceTest 
{
	@InjectMocks
	InvGrupoServiceImpl invGrupoServiceImpl;
	

	
	@Mock
	InvGrupoRepositorio invGrupoRepositorio;
	
	
	@Test
	public void testcrearArea() throws RuntimeException
	{
		InvGrupoCreacionDto invGrupoCreacionDto = InvGrupoCreacionDto.builder()
				.codGrupo("1")
				.descriGrupo("Prueba")
				.build();
		InvGrupo  gruposave = InvGrupo.builder()
				.codGrupo(invGrupoCreacionDto.getCodGrupo())
				.descriGrupo(invGrupoCreacionDto.getDescriGrupo())
				.status('A')
				.build();
		when(invGrupoRepositorio.save(any())).thenReturn(gruposave);
		
		invGrupoServiceImpl.crearInvGrupo(invGrupoCreacionDto);
	}

}
