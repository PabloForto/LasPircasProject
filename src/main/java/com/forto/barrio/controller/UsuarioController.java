package com.forto.barrio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forto.barrio.model.Perfil;
import com.forto.barrio.model.Usuario;
import com.forto.barrio.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/index")
	public String mostrarUsuarios(Model model) {
		List<Usuario> user = userService.buscarTodas();
		model.addAttribute("usuarios", user);
		model.addAttribute("perfil", new Perfil());
		return "usuario/listUsuarios";
	}

	/**
	 * Método que muestra el formulario para que se registren nuevos
	 * usuarios(porteros).
	 * 
	 * @param usuario
	 * @return
	 */
	@GetMapping("/signup")
	public String crear(Usuario usuario, Model model) {
		System.out.println("Entre1");
		return "usuario/formUsuario";
	}

	/**
	 * Método que guarda en la base de datos el usuario(Portero) registrado
	 * 
	 * @param usuario
	 * @param attributes
	 * @return
	 */
	@PostMapping("/signup")
	public String guardar(Usuario usuario, RedirectAttributes attributes) {
		System.out.println("Entre2");
		// Recuperamos el password en texto plano
		String pwdPlano = usuario.getPassword();
		// Encriptamos el pwd BCryptPasswordEncoder
		String pwdEncriptado = passwordEncoder.encode(pwdPlano);
		// Hacemos un set al atributo password (ya viene encriptado)
		usuario.setPassword(pwdEncriptado);
		usuario.setEstatus(1); // Activado por defecto

		// Creamos el Perfil que le asignaremos al usuario nuevo
		Perfil perfil = new Perfil();
		perfil.setId(2); // Perfil USUARIO
		usuario.agregar(perfil);

		/**
		 * Guardamos el usuario en la base de datos. El Perfil se guarda automaticamente
		 */
		userService.guardar(usuario);

		attributes.addFlashAttribute("msg", "Has sido registrado. ¡Ahora puedes ingresar al sistema!");

		return "redirect:/usuarios/index";
	}

	/**
	 * Método que elimina un Usuario(Portero) de la base de datos
	 * 
	 * @param idUsuario
	 * @param attributes
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String editarUsuario(@PathVariable("id") Integer idUsuario, Model model, RedirectAttributes attributes) {
		// Eliminamos el usuario
		userService.eliminar(idUsuario);
		attributes.addFlashAttribute("msg", "El usuario fue eliminado!.");
		return "redirect:/usuarios/index";
	}

	/**
	 * Método para activar un usuario
	 * 
	 * @param idUsuario
	 * @param attributes
	 * @return
	 */
	@GetMapping("/unlock/{id}")
	public String activar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		userService.activar(idUsuario);
		attributes.addFlashAttribute("msg", "El usuario fue activado y ahora tiene acceso al sistema.");
		return "redirect:/usuarios/index";
	}

	/**
	 * Método para bloquear un usuario
	 * 
	 * @param idUsuario
	 * @param attributes
	 * @return
	 */
	@GetMapping("/lock/{id}")
	public String bloquear(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		userService.bloquear(idUsuario);
		attributes.addFlashAttribute("msg", "El usuario fue desacticado y ya no tiene acceso al sistema");
		return "redirect:/usuarios/index";
	}

}
