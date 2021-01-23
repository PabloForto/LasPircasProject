package com.forto.barrio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forto.barrio.model.Propietario;
import com.forto.barrio.model.Usuario;
import com.forto.barrio.service.IPropietarioService;
import com.forto.barrio.service.IUsuarioService;


@Controller
public class HomeController {

	@Autowired
	private IPropietarioService servicePropietario;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@GetMapping("/")
	public String indexGeneral() {
		return "indexGeneral";
	}
	
	/**
	 * Método que esta mapeado al botón Ingresar en el menú
	 * 
	 * @param authentication
	 * @param session
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Authentication auth, HttpSession session) {
		String username = auth.getName();
		System.out.println("Nombre de usuario: " + username);
		
		for (GrantedAuthority rol: auth.getAuthorities()) {
			System.out.println("ROL: " + rol.getAuthority());
		}
		
		if(session.getAttribute("usuario") == null) {
			Usuario usuario = serviceUsuario.buscarPorUsername(username);
			usuario.setPassword(null);
			System.out.println("Usuario: " + usuario);
			session.setAttribute("usuario", usuario);
		}
		return"redirect:/home";
	}

	/**
	 * Método que esta mapeado el inicio ya logueado 
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String mostrarHome(Model model) {
		List<Propietario> lista = servicePropietario.buscarTodos();
		model.addAttribute("propietarios", lista);
		return "home";
	}
	
	/**
	 * Método que muestra el formulario de login personalizado.
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String loginA() {
		return"loginAdministrador";
	}
	
	/**
	 * Método personalizado para cerrar la sesión del usuario
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		SecurityContextLogoutHandler logoutHandler =
		new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/";
	}
	
	/**
	 * Utileria para encriptar texto con el algorito BCrypt
	 * 
	 * @param texto
	 * @return
	 */
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}

}
