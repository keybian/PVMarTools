/**
 * 
 */
package com.kp.martuls.dao.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Padilla
 *
 */

@Getter


@Setter


@NoArgsConstructor


@Builder

/**
 * Instanciation de area_critica.
 *
 * @param idGrupo
 * @param codGrupo
 * @param descriGrupo
 * @param statusGrupo
 */
@AllArgsConstructor
/**
 * Grupos del Inventario
 */
@Entity
@Table(name ="inv_grupo")
public class InvGrupo implements java.io.Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6455208382823754644L;


	/** id Grupo Productos */
	@Id
	@Column(name = "GRU_ID", unique = true, nullable = false,precision = 10, scale =0)
	//@SequenceGenerator(name = "AreaCriticagen", sequenceName = "AreaCritica_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrupo;
	
	
	/** codigo grupo */
	@Column(name = "GRU_CODIGO", nullable = false, precision = 10, scale = 0)
	private String codGrupo;
	
	/** Descripcion Grupo */
	@Column(name = "GRU_DESCRI",nullable = false,precision = 700,scale = 0)
	private String descriGrupo;
	
	
	/** Status Grupo */
	@Column(name = "GRU_STATUS", nullable = false)
	private char status;
	
	
	
	

	

}
