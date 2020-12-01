package com.forto.barrio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.forto.barrio.model.RegistroV;
import com.forto.barrio.model.Visita;
import com.forto.barrio.repository.RegistroVRepository;

@Service
public class RegistroVService implements IRegistroVService {

	@Autowired
	private RegistroVRepository registroRepo;
	
	@Override
	public List<RegistroV> buscarTodas() {
		return registroRepo.findAll();
	}

	@Override
	public RegistroV generarRegistroconIgreso(Visita visita) {
		RegistroV r = new RegistroV();
		r.setRegistro(new Date());
		r.setIngreso(new Date());
		r.setVisita(visita);
		return registroRepo.save(r);
	}

	@Override
	public RegistroV generarEgreso(Integer idRegistro) {
		RegistroV r = registroRepo.getOne(idRegistro);
		r.setEgreso(new Date());
		return registroRepo.save(r);
	}

	@Override
	public List<RegistroV> listarhoy() {
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
		return registroRepo.findByIngresoBetween(date, date2);
	}
	

}
