package com.kp.martuls.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestDtos 
{
	
	@Test
	public void testAreaCriticaCreacionDto() 
	{
		InvGrupoCreacionDto.builder()
			.codGrupo(null)
			.descriGrupo(null)
			.build();
		InvGrupoCreacionDto.builder().toString();
			
		
	}

	
}
