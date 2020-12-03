/*
 * Controlador encargado de mostrar el Home,Logueo este controlador 
 * depende de quien ingrese si es un administrador o un portero.... 
 * proximamente tendria que poder ingresar la parter de los usuarios(propietarios)
 * 
 */

package com.forto.barrio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@GetMapping("/home")
	public String mostrarHome(Model model) {
		List<Propietario> lista = servicePropietario.buscarTodos();
		model.addAttribute("propietarios", lista);
		return "home";
	}
	
	@GetMapping("/login")
	public String loginA() {
		return"loginAdministrador";
	}
	
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}

}
