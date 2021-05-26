package com.forto.barrio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forto.barrio.model.Trabajador;
import com.forto.barrio.service.ITrabajadorService;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

	@Autowired
	private ITrabajadorService trabajadorService;
	
	
	@GetMapping("/index")
	public String mostrarIndexTrabajador(Model model) {
		List<Trabajador> lista = trabajadorService.buscarTodos(); 
		model.addAttribute("trabajador", lista);
		return "trabajador/index";
	}
	
	@GetMapping("/create")
	public String cargarNuevoTrabajador(Trabajador trabajador) {
		return "trabajador/formTrabajador";
	}
	
	@PostMapping("/save")
	public String guardarTrabajador(Trabajador trabajador,  BindingResult result, RedirectAttributes attributes ) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error);
			}
			return "trabajador/formTrabajador";
		}
		trabajadorService.guardar(trabajador);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/trabajador/index";
	}
}

