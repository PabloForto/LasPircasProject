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

import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Registro;
import com.forto.barrio.service.IPropietarioService;
import com.forto.barrio.service.IRegistroService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

	@Autowired
	private IPropietarioService servicePropietario;
	
	@Autowired														
    private IRegistroService serviceRegistro;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Propietario> lista = servicePropietario.buscarTodos();
		List<Registro> lista2 = serviceRegistro.buscarTodas();
		model.addAttribute("propietarios", lista);
		model.addAttribute("registros", lista2);
		return "propietario/listPropietarios";
	}

	@GetMapping("/create")
	public String crear(Propietario propietario, Model model) {

		return "propietario/formPropietarios";
	}

	@PostMapping("/save")
	public String guardar(Propietario propietario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "propietario/formPropietarios";
		}
		
		servicePropietario.guardar(propietario);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Propietario: " + propietario);
		return "redirect:/propietarios/index";
	}

	/*
	 * !!!Modificar por que no esta eliminando  ¿tambien tiene que eliminar el registro?!!!!
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idPropietario, @PathVariable("idRegistro") Integer idRegistro, Model model, RedirectAttributes attributes) {
		//System.out.println("Borrando propietario con id: " + idPropietario);
		
		serviceRegistro.eliminarRegistro(idRegistro);
		
		servicePropietario.eliminar(idPropietario);
		attributes.addFlashAttribute("msg", "Propietario eliminado!");
		return "redirect:/propietarios/index";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idPropietario, Model model) {
		Propietario propietario = servicePropietario.buscarPorId(idPropietario);
		model.addAttribute("propietario", propietario);
		return "propietario/formPropietarios";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idPropietario, Model model) {
		Propietario propietario = servicePropietario.buscarPorId(idPropietario);
		model.addAttribute("propietario", propietario);
		return"detalle";
	}

}
