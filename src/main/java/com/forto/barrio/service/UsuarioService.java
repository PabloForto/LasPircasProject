package com.forto.barrio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forto.barrio.model.Usuario;
import com.forto.barrio.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuarioRepo.save(usuario);
		
	}

	@Override
	public List<Usuario> buscarTodas() {
		return usuarioRepo.findAll();
	}

	@Override
	public void eliminar(Integer idUsuario) {
		usuarioRepo.deleteById(idUsuario);
		
	}

	@Override
	public void cargar(Integer idUsuario) {
		usuarioRepo.findById(idUsuario);
		
	}

}
