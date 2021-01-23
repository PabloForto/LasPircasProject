package com.forto.barrio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public Usuario buscarPorUsername(String username) {
		return usuarioRepo.findByUsername(username);
	}

	@Override
	public Usuario buscarPorId(Integer idUsusario) {
		Optional<Usuario> optional = usuarioRepo.findById(idUsusario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	
	@Transactional
	@Override
	public int bloquear(int idUsuario) {
		int rows = usuarioRepo.lock(idUsuario);
		return rows;
	}

	@Transactional
	@Override
	public int activar(int idUsuario) {
		int rows = usuarioRepo.unlock(idUsuario);
		return rows;
	}
	
	
	
	

}
