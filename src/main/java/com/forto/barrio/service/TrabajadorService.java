package com.forto.barrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Trabajador;
import com.forto.barrio.repository.TrabajadorRepository;

@Service
public class TrabajadorService implements ITrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepo;
	
	@Override
	public void guardar(Trabajador trabajador) {
		trabajadorRepo.save(trabajador);
	}

	@Override
	public List<Trabajador> buscarTodos() {
		return trabajadorRepo.findAll();
	}

	@Override
	public Trabajador buscarPorId(Integer idTrabajador) {
		Optional<Trabajador> optional = trabajadorRepo.findById(idTrabajador);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Trabajador> buscarPorNonbre(String nombreTrabajador) {
		return trabajadorRepo.findByNombre(nombreTrabajador);
	}

	@Override
	public List<Trabajador> buscarPorApellido(String apellidoTrabajador) {
		return trabajadorRepo.findByApellido(apellidoTrabajador);
	}

	@Override
	public List<Trabajador> buscarPorDocumento(String documentoTrabajador) {
		return trabajadorRepo.findByDocumento(documentoTrabajador);
	}

}
