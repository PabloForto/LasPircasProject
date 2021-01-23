package com.forto.barrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.forto.barrio.model.Usuario;

/*
 * Repositorio Usuario.
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);

	List<Usuario> findByNombre(String nombre);

	List<Usuario> findByEmail(String email);

	List<Usuario> findByEstatus(String estatus);

	List<Usuario> findByPassword(String password);
	
	@Modifying
	@Query("UPDATE Usuario u SET u.estatus=0 WHERE u.id = :paramIdUsuario")
	int lock(@Param("paramIdUsuario") int idUsuario);
	
	@Modifying
	@Query("UPDATE Usuario u SET u.estatus=1 WHERE u.id = :paramIdUsuario")
	int unlock(@Param("paramIdUsuario") int idUsuario);
	

}
