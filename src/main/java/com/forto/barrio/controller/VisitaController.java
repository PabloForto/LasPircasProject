package com.forto.barrio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forto.barrio.model.Visita;
import com.forto.barrio.service.IVisitaService;

@Controller
@RequestMapping("/visitas")
public class VisitaController {

	@Autowired
	private IVisitaService serviceVisita;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Visita>lista = serviceVisita.buscarTodos();
		model.addAttribute("visitas", lista);
		return "visita/listVisita";
	}
	
	/**
	 * Método que muestra el formulario para crear una nueva Visita
	 * 
	 * @param visita
	 * @return
	 */
	@GetMapping("/create")
	public String crear(Visita visita, Model model) {
		return"visita/formVisita";
	}
	
	/**
	 * Método que guarda una Visita en la base de datos
	 * 
	 * @param visita
	 * @param result
	 * @param model
	 * @param attributes
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Visita visita, BindingResult result, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrieron error: " + error.getDefaultMessage());
			}
			return "visita/formVisita";
		}
		serviceVisita.guardar(visita);
		attribute.addFlashAttribute("msg", "Registro Guardado!");
		System.out.println("Visita: " + visita);
		return"redirect:/visitas/index";	
		
	}
	
	/**
	 * Método que elimina una Visita de la base de datos
	 * 
	 * @param idVisita
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idVisita, Model model, RedirectAttributes attributes) {
		System.out.println("Borrando propietario con id: " + idVisita);
		serviceVisita.eliminar(idVisita);
		attributes.addFlashAttribute("msg", "Visita eliminada!");
		return "redirect:/visitas/index";
	}
	
	/**
	 * Método que renderiza el formulario HTML para editar una visita
	 * 
	 * @param idVisita
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idVisita, Model model) {
		Visita visita = serviceVisita.buscarPorId(idVisita);
		model.addAttribute("visita", visita);
		return"visita/formVisita";
	}
}
