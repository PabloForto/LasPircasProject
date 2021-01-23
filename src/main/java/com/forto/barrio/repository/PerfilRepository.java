package com.forto.barrio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forto.barrio.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	List<Perfil> findByPerfil(String perfil);

//	List<Perfil> findByPerfilesBetween(String perfil1, String perfil2);
}
