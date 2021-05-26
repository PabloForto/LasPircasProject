package com.forto.barrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.forto.barrio.model.Propietario;
import com.forto.barrio.repository.PropietarioRepository;

/*
 * Clase de servicio que implementa los metodos para la entidad Propietario.
 * se conecta con el repositorio del Propietario para poder dsarrollar la logica de servicio 
 * del sistema.
 */

@Service
public class PropietarioService implements IPropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepo;

	public void guardar(Propietario propietario) {
		propietarioRepo.save(propietario);

	}

	public List<Propietario> buscarTodos() {
		return propietarioRepo.findAll();
	}

	public Propietario buscarPorId(Integer idPropietario) {
		Optional<Propietario> optional = propietarioRepo.findById(idPropietario);
		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

//	public List<Propietario> buscarPorLoteYnumero(String lotePropietario, int numeroPropietario) {
//		return propietarioRepo.findByLoteAndNumeroOrderByLoteAsc(lotePropietario, numeroPropietario);
//
//	}

	public List<Propietario> buscarPorNombre(String nombrePropietario) {
		return propietarioRepo.findByNombre(nombrePropietario);
	}

	public List<Propietario> buscarPorApellido(String apellidoPropietario) {
		return propietarioRepo.findByApellido(apellidoPropietario);

	}

	public List<Propietario> buscarPorDominio(String dominioPropietario) {
		return propietarioRepo.findByDominio(dominioPropietario);

	}

//	public List<Propietario> buscarPorLotePorNumeroPorNombrePorApellido(String lotePropietario, int numeroPropietario,
//			String nombrePropietario, String apellidoPropietario){
//
//		return propietarioRepo.findByLoteAndNumeroAndNombreAndApellidoOrderByLoteAsc(lotePropietario, numeroPropietario,
//				nombrePropietario, apellidoPropietario);
//
//	}

	public List<Propietario> buscarPorNombrePorApellido(String nombrePropietario, String apellidoPropietario) {
		return propietarioRepo.findByNombreAndApellidoOrderByIdAsc(nombrePropietario, apellidoPropietario);
	}

	public void eliminar(Integer idPropietario) {
		propietarioRepo.deleteById(idPropietario);

	}

	public List<Propietario> listarDisponibles() {
		return propietarioRepo.findByRegistrosIsNullOrRegistrosEgresoIsNotNullAndRegistrosIngresoIsNotNull();
	}

}
