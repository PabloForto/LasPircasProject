package com.forto.barrio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Perfil;
import com.forto.barrio.repository.PerfilRepository;



@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepo;
	
	public List<Perfil> buscarTodos() {
		return perfilRepo.findAll();
	}

	
	

}
