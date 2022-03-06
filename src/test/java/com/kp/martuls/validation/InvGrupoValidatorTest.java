
package com.kp.martuls.validation;




import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

import com.kp.martuls.dao.repositorios.InvGrupoRepositorio;
import com.kp.martuls.dto.InvGrupoCreacionDto;

@RunWith(MockitoJUnitRunner.class)
@TestPropertySource("classpath:messages.properties")
@PropertySource(value = "classpath:com/kp/gestion/configuracion/messages.properties",encoding = "UTF-8")
public class InvGrupoValidatorTest {
	
	@InjectMocks
	InvGrupoValidador invGrupoValidador;
	
	@Mock
	Validar validar;
	
	@Mock
	InvGrupoRepositorio invGrupoRepositorio;
	
	@Value("${cod.msg0001}")
    private String msg0001;
    
    @Value("${cod.msg0002}")
    private String msg0002;
    
    @Value("${cod.msg0003}")
    private String msg0003;
    
    @Value("${cod.msg0004}")
    private String msg0004;
    
    @Value("${cod.msg0005}")
    private String msg0005;
    
    @Value("${cod.msg0006}")
    private String msg0006;
    
    @Value("${cod.msg0007}")
    private String msg0007;
    
    @Value("${cod.msg0008}")
    private String msg0008;
    
    @SuppressWarnings("deprecation")
	@Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private InvGrupoCreacionDto invGrupoCreacionDto;
    
    public InvGrupoValidatorTest()
    {
    	super();
    }
    
    @Before
    public void builInvGrupoCreacionDto()
    {
    	invGrupoCreacionDto = InvGrupoCreacionDto.builder().build();
    	
    	invGrupoCreacionDto.setCodGrupo("PRU001");
    	invGrupoCreacionDto.setDescriGrupo("Prueba 001");
    }
	

	
	@Test
	public void testConPresenciaOKAreaValidador() throws RuntimeException
	{
		
		
		invGrupoValidador.validarInvGrupoCreacionControlPresencia(invGrupoCreacionDto);
	
	}
	
	@Test
	public void testControlPresenciaCodAreaValidador() throws RuntimeException
	{
		
		invGrupoCreacionDto.setCodGrupo("");
		when(validar.getMsg0002() + " Grupo de Inventario").thenReturn(msg0002 + " Grupo de Inventario");
		thrown.expectMessage(msg0002 + " Grupo de Inventario");
		invGrupoValidador.validarInvGrupoCreacionControlPresencia(invGrupoCreacionDto);
	
	}
	
	@Test
	public void testControlPresenciaDescripValidador() throws RuntimeException
	{
		
		invGrupoCreacionDto.setDescriGrupo(null);
		when(validar.getMsg0003() + " Grupo de Inventario").thenReturn(msg0003 + " Grupo de Inventario");
		thrown.expectMessage(msg0003 + " Grupo de Inventario");
		invGrupoValidador.validarInvGrupoCreacionControlPresencia(invGrupoCreacionDto);
	
	}
	
	@Test
	public void testConFormaOKAreaValidador() throws RuntimeException
	{
		
		invGrupoValidador.validarInvGrupoCreacionControlForma(invGrupoCreacionDto);
	
	}
	
	@Test
	public void testControlFormaCodAreaValidador() throws RuntimeException
	{
		
		invGrupoCreacionDto.setCodGrupo("001");
		when(validar.getMsg0007() + ", permitido 6").thenReturn(msg0007 + ", permitido 6");
		thrown.expectMessage(msg0007 + ", permitido 6");
		invGrupoValidador.validarInvGrupoCreacionControlForma(invGrupoCreacionDto);
	
	}
	
	@Test
	public void testControlOKFondoValidador() throws RuntimeException
	{
		
		
		when(invGrupoRepositorio.countByCodeGrupo(anyString())).thenReturn(0L);
		invGrupoValidador.validarInvGrupoCreacionControlFondo(invGrupoCreacionDto);
	
	}
	
	@Test
	public void testControlCodAreaFondoValidador() throws RuntimeException
	{
		
		invGrupoCreacionDto.setCodGrupo("001");
		when(invGrupoRepositorio.countByCodeGrupo(anyString())).thenReturn(1L);
		when(validar.getMsg0008() + ", intente de nuevo").thenReturn(msg0008 + ", intente de nuevo");
		thrown.expectMessage(msg0008 + ", intente de nuevo");
		invGrupoValidador.validarInvGrupoCreacionControlFondo(invGrupoCreacionDto);
	
	}



	

}
