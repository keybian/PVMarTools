/**
 * 
 */
package com.kp.martuls.dao.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kp.martuls.dao.entitys.InvGrupo;

/**
 * @author Padilla
 *
 */
public interface InvGrupoRepositorio extends CrudRepository<InvGrupo, Long> {
	
	
    @Query("SELECT COUNT(ig.codGrupo) "
        + " FROM InvGrupo ig "
        + " WHERE ig.codGrupo = :codeGrupo ")
    Long countByCodeGrupo(@Param("codeGrupo") String codeGrupo);
    

}
