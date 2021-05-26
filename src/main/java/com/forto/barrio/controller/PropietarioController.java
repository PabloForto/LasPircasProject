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

	/**
	 * Método que muestra el formulario para crear un nuevo Propietario
	 * 
	 * @param propietario
	 * @return
	 */
	@GetMapping("/create")
	public String crear(Propietario propietario, Model model) {
		return "propietario/formPropietarios";
	}

	/**
	 * Método que guarda un Propietario en la base de datos
	 * 
	 * @param propietario
	 * @param result
	 * @param model
	 * @param attributes
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Propietario propietario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error);
			}
			return "propietario/formPropietarios";
		}
		
		servicePropietario.guardar(propietario);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Propietario: " + propietario);
		return "redirect:/propietarios/index";
	}

	/**
	 * Método que elimina un Propietario de la base de datos
	 * 
	 * @param idPropietario
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idPropietario, Model model, RedirectAttributes attributes) {
		System.out.println("Borrando propietario con id: " + idPropietario);
		servicePropietario.eliminar(idPropietario);
		attributes.addFlashAttribute("msg", "Propietario eliminado!");
		return "redirect:/propietarios/index";
	}

	/**
	 * Método que renderiza el formulario HTML para editar un propietario
	 * 
	 * @param idPropietario
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idPropietario, Model model) {
		Propietario propietario = servicePropietario.buscarPorId(idPropietario);
		model.addAttribute("propietario", propietario);
		return "propietario/formPropietarios";
	}
	
	/**
	 * Método para renderizar la vista de los Detalles para un determinado Propietario.
	 * 
	 * @param idPropietario
	 * @param model
	 * @return
	 */
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idPropietario, Model model) {
		Propietario propietario = servicePropietario.buscarPorId(idPropietario);
		model.addAttribute("propietario", propietario);
		return"propietario/detalle";
	}

}
