package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Usuario;

/*
 * Interface que implementa los metodos para el servicio de Usuarios.
 */

public interface IUsuarioService {

	void guardar(Usuario usuario);

	List<Usuario> buscarTodas();

	void eliminar(Integer idUsuario);

	void cargar(Integer idUsuario);
	
	Usuario buscarPorUsername(String username);

}
