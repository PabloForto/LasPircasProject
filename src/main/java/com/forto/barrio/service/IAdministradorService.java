package com.forto.barrio.service;

import java.util.List;

import com.forto.barrio.model.Administrador;

public interface IAdministradorService  {
	void guardar(Administrador admin);
	List<Administrador> buscarTodo();
	Administrador buscarPorId(Integer idAdmin);

}
