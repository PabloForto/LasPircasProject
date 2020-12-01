/*
 * Controlador encargado de mostrar el Home,Logueo este controlador 
 * depende de quien ingrese si es un administrador o un portero.... 
 * proximamente tendria que poder ingresar la parter de los usuarios(propietarios)
 * 
 */

package com.forto.barrio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.forto.barrio.model.Propietario;
import com.forto.barrio.service.IPropietarioService;

@Controller
public class HomeController {

	@Autowired
	private IPropietarioService servicePropietario;

	@GetMapping("/")
	public String indexGeneral() {
		return "indexGeneral";
	}

	@GetMapping("/home")
	public String mostrarHome(Model model) {
		List<Propietario> lista = servicePropietario.buscarTodos();
		model.addAttribute("propietarios", lista);
		return "home";
	}

}
