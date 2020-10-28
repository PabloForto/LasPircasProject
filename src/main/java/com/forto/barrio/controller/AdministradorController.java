package com.forto.barrio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forto.barrio.model.Administrador;
import com.forto.barrio.service.AdministradorService;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private AdministradorService serviceAdmin;
	
	
	@GetMapping("/loginAdmin")
	public String logeoAdmin() {
		return"administrador/loginAdmin";
	}
	
	@GetMapping("/create")
	 public String formRegistroAdmin(Administrador admin) {
		 return"administrador/formRegistroAdmin";
	 }
	
	@PostMapping("/save")
	public String guardar(Administrador admin, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "administrador/formRegistroAdmin";
		}
		serviceAdmin.guardar(admin);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Administrador: " + admin);
		return"redirect:/administrador/loginAdmin";
		
		
		
	}
	 

}
