package com.kp.martuls.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel

@Getter

@Setter

@Builder

@NoArgsConstructor

/**
 * Instancia de Grupo de Inventario
 * 
 * @param codgrupo codigo personalizado empresarial
 * @param descripcion del grupo de inventario
 *
 */
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class InvGrupoCreacionDto implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6441538116126398915L;
	
	@ApiModelProperty
	private String codGrupo;
	
	
	@ApiModelProperty
	private String descriGrupo;
	
	
	

}
