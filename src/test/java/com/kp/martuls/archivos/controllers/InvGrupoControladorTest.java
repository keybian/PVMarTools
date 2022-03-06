package com.kp.martuls.archivos.controllers;


import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kp.martuls.dto.InvGrupoCreacionDto;
import com.kp.martuls.services.impl.InvGrupoServiceImpl;
import com.kp.martuls.validation.InvGrupoValidador;

@RunWith(MockitoJUnitRunner.class)
public class InvGrupoControladorTest 
{
	@InjectMocks
	InvGrupoControlador invGrupoControlador;
	
	@Mock
	InvGrupoServiceImpl invGrupoServiceImpl;
	
	@Mock
	InvGrupoValidador invGrupoValidador;
	
	
	
	@Test
	public void testCrearAreaCritica() 
	{
		InvGrupoCreacionDto invGrupoCreacionDto = InvGrupoCreacionDto.builder()
				.codGrupo("1")
				.descriGrupo("1")
				.build();
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
		when(invGrupoServiceImpl.crearInvGrupo(invGrupoCreacionDto)).thenReturn(1L);
		
		invGrupoControlador.crearInvGrupo(invGrupoCreacionDto);
		
	}

}
