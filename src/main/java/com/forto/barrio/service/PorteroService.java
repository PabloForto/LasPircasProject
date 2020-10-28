package com.forto.barrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Portero;
import com.forto.barrio.repository.PorteroRepository;

@Service
public class PorteroService implements IPorteroService {

	@Autowired
	private PorteroRepository porteroRepo;
	
	
	public void guardar(Portero portero) {
		porteroRepo.save(portero);
		
	}

	
	public List<Portero> buscarTodos() {
	  return porteroRepo.findAll();
		
	}

	
	public Portero buscarPorId(Integer idPortero) {
		Optional<Portero> optional = porteroRepo.findById(idPortero);
		if(optional.isPresent()) {
		  return optional.get();
		}
		return null;
	}
	
	

}
