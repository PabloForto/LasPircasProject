/*
 * Clase que controla la implementacion de los metodos y que se encarga del service 
 * donde se llama a los repositorios de la entidad propietario y registro.
 */
package com.forto.barrio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Propietario;
//import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Registro;
import com.forto.barrio.model.Visita;
import com.forto.barrio.repository.RegistroRepository;

@Service
public class RegistroService implements IRegistroService {

	@Autowired
	private RegistroRepository registroRepo;
	

	@Override
	public Registro generarRegistroConEgreso(Propietario propietario) {
		Registro r = new Registro();
		r.setRegistro(new Date());
		r.setEgreso(new Date());
		r.setPropietario(propietario);
		return registroRepo.save(r);
	}
	
	@Override
	public Registro generarIngreso(Integer idRegistro) {
		Registro r = registroRepo.getOne(idRegistro);
		r.setIngreso(new Date());
		return registroRepo.save(r);
	}
	
	@Override
	public Registro generarRegistroconIgreso(Visita visita) {
		Registro r = new Registro();
		r.setRegistro(new Date());
		r.setIngreso(new Date());
		r.setVisita(visita);
		return registroRepo.save(r);
	}
	

	@Override
	public Registro generarEgreso(Integer idRegistro) {
		Registro r = registroRepo.getOne(idRegistro);
		r.setEgreso(new Date());
		return registroRepo.save(r);
	}

	
	@Override
	public List<Registro> listarhoy(){
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String hoySinHora = f.format(new Date());
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
    	Date date2 = new Date();
		try {
			;
			date = formater.parse(hoySinHora.concat(" 00:00"));
			date2 = formater.parse(hoySinHora.concat(" 24:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return registroRepo.findByEgresoBetween(date, date2);
	}

	/*
	 * Metodo para mostrar todos los registros guardados 	
	 */
	public List<Registro> buscarTodas() {
		return registroRepo.findAll();
	}

	@Override
	public void eliminarRegistro(Integer idRegistro) {
		 registroRepo.deleteById(idRegistro);
		
	}

}

	
	
	


