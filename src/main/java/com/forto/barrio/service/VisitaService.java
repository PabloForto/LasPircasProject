package com.forto.barrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Visita;
import com.forto.barrio.repository.VisitaRepository;

@Service
public class VisitaService implements IVisitaService {

	@Autowired
	private VisitaRepository visitaRepo;

	public void guardar(Visita visita) {
		visitaRepo.save(visita);

	}

	public List<Visita> buscarTodos() {
		return visitaRepo.findAll();
	}

	/*
	 * Metodo para buscar por ID de la Visita.
	 */
	public Visita buscarPorId(Integer idVisita) {
		Optional<Visita> optional = visitaRepo.findById(idVisita);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	/*
	 * Metodo para buscar por Nombre de la visita.
	 */
	public List<Visita> buscarPorNombre(String nombreVisita) {
		return visitaRepo.findByNombre(nombreVisita);

	}

	/*
	 * Metodo para buscar por Apellido de la visita.
	 */
	public List<Visita> buscarPorApellido(String apellidoVisita) {
		return visitaRepo.findByApellido(apellidoVisita);

	}

	/*
	 * Metodo para buscar por nunmero de Documento de la visita.
	 */
	public List<Visita> buscarPorDocumento(Integer documentoVisita) {
		return visitaRepo.findByDocumento(documentoVisita);

	}

	/*
	 * Metodo para buscar por lote y numero de lote de la visita ordenado por id
	 * ascendente, para saber a que propiedad se dirige o a que propietario
	 * pertenece.
	 */
	public List<Visita> buscarPorLotePorNumero(String loteVisita, int numeroVisita) {
		return visitaRepo.findByLoteAndNumeroOrderByIdAsc(loteVisita, numeroVisita);

	}

	/*
	 * Metodo para buscar por dominio(patente del vehiculo) de la visita.
	 */
	public List<Visita> buscarPorDominio(String dominioVisita) {
		return visitaRepo.findByDominio(dominioVisita);

	}

	public void eliminar(Integer idVisita) {
		visitaRepo.deleteById(idVisita);

	}

}
