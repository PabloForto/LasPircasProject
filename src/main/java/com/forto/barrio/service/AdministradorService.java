package com.forto.barrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Administrador;
import com.forto.barrio.repository.AdministradorRepository;

@Service
public class AdministradorService implements IAdministradorService {

	@Autowired
	private AdministradorRepository adminRepo;
	
	public void guardar(Administrador admin) {
	  adminRepo.save(admin);
		
	}

	
	public List<Administrador> buscarTodo() {
		return adminRepo.findAll();
	}

	
	public Administrador buscarPorId(Integer idAdmin) {
		Optional<Administrador> optional = adminRepo.findById(idAdmin);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
