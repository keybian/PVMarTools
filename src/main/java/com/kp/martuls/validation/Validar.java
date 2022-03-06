
package com.kp.martuls.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * Validar Clase para validaciones comunes.
 *
 * 
 */
@NoArgsConstructor
@Getter
@Component
@PropertySource(value = "classpath:com/kp/martuls/configuracion/messages.properties",encoding = "UTF-8")
public class Validar
{
	
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
    


}
