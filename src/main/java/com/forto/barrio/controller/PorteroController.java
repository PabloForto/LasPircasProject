/*
 * Controlador encargado de realizar los trabajos de los registros tanto de ingreso/egresos
 * de propietarios,visitas,fletes,etc...
 */

package com.forto.barrio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Registro;
import com.forto.barrio.model.Visita;
import com.forto.barrio.service.IRegistroService;
import com.forto.barrio.service.PropietarioService;
import com.forto.barrio.service.VisitaService;


@Controller
@RequestMapping("/porteros")
public class PorteroController {
	
	@Autowired
	private PropietarioService propietarioService; 
	
	@Autowired
	private VisitaService visitaService;
	
	@Autowired
	private IRegistroService serviceRegistro;
	
	
	@GetMapping("/index")
	public String mostrarIngresosEgresosDePropietarios( Model model) {
		model.addAttribute("registros", new Registro());
		model.addAttribute("propietarios",propietarioService.listarDisponibles());
		model.addAttribute("registros", serviceRegistro.listarhoy());
		return"portero/listIngresosEgresos";
	}
	
	
	@GetMapping("/generarEgreso")
	public String generarEgreso(@RequestParam("idPropietario") Integer idPropietario, Model model, RedirectAttributes attributes) {
		Propietario p = propietarioService.buscarPorId(idPropietario);
		model.addAttribute("registros", serviceRegistro.generarRegistroConEgreso(p));
		attributes.addFlashAttribute("msg","Egreso guardado!");
		return"redirect:/porteros/index";
	}
	
	
	@GetMapping("/generarIngreso/{id}")
	public String generarIngreso(@PathVariable("id") Integer idRegistro, Model model, RedirectAttributes attributes) {
	   serviceRegistro.generarIngreso(idRegistro);
	  attributes.addFlashAttribute("msg","Ingreso guardado!");
	  return "redirect:/porteros/index";
	}
	
	
    /*
 	 * 	No esta apuntando al objeto visita!!!
	 */
	@GetMapping("/index2")
	public String mostrarIngresosEgresosDeVisitas(Model model) {
		model.addAttribute("registros", new Registro());
		model.addAttribute("visitas", visitaService.listarDisponibles());
		model.addAttribute("registros", serviceRegistro.listarHoy());
		return"portero/listEgresosIngresos";
	}
	
	
	@GetMapping("/generarIngreso")
	public String generarIngresos(@RequestParam("idVisita") Integer idVisita, Model model, RedirectAttributes attributes) {
		Visita v = visitaService.buscarPorId(idVisita);
		model.addAttribute("registros", serviceRegistro.generarRegistroconIgreso(v));
		attributes.addFlashAttribute("msg","Ingreso guardado!");
		return"redirect:/porteros/index2";
	}
	
	@GetMapping("/generarEngreso/{id}")
	public String generarEngreso(@PathVariable("id") Integer idRegistro, Model model, RedirectAttributes attributes) {
	   serviceRegistro.generarEgreso(idRegistro);
	  attributes.addFlashAttribute("msg","Engreso guardado!");
	  return "redirect:/porteros/index2";
	}
	
	
}
