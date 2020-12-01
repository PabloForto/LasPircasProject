package com.forto.barrio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Registro;
import com.forto.barrio.repository.RegistroRepository;

/*
 * Clase de servicio que se encarga de implementar los metodos para la entidad Registro
 * se conecta con el repositorio del Registro de propietarios para poder dsarrollar la logica de servicio 
 * del sistema.
 */

@Service
public class RegistroService implements IRegistroService {

	@Autowired
	private RegistroRepository registroRepo;
	
	//Metodo encargado de generar el registro de egreso del barrio del propietario.
	@Override
	public Registro generarRegistroConEgreso(Propietario propietario) {
		Registro r = new Registro();
		r.setRegistro(new Date());
		r.setEgreso(new Date());
		r.setPropietario(propietario);
		return registroRepo.save(r);
	}

	/*
	 * Metodo de generar el registro de ingreso al barrio del propietario.
	 * Recibe como parametro id del Registro ya realizado 
	 * @param idRegistro
	 */
	@Override
	public Registro generarIngreso(Integer idRegistro) {
		Registro r = registroRepo.getOne(idRegistro);
		r.setIngreso(new Date());
		return registroRepo.save(r);
	}

	@Override
	public Registro generarEgreso(Integer idRegistro) {
		Registro r = registroRepo.getOne(idRegistro);
		r.setEgreso(new Date());
		return registroRepo.save(r);
	}

	@Override
	public List<Registro> listarhoy() {

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

	public List<Registro> buscarTodas() {
		return registroRepo.findAll();
	}

	@Override
	public void eliminarRegistro(Integer idRegistro) {
		registroRepo.deleteById(idRegistro);

	}

}
	
	
	


