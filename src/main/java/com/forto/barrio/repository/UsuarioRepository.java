package com.forto.barrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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

}
