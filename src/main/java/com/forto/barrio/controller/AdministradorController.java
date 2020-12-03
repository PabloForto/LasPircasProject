package com.forto.barrio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@GetMapping("/loginA")
	public String loginAdministrador() {
		return "administrador/loginAdministrador";
	}

}
