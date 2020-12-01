package com.forto.barrio.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, estatus from usuario where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from usuario_perfiles up " +
		"inner join usuario u on u.id = up.Usuario_id " +
		"inner join perfil p on p.id = up.perfiles_id " +
		"where u.username = ?");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		// Los recursos estáticos no requieren autenticación
		.antMatchers(
		"/bootstrap/**",
		"/images/**",
		"/tinymce/**",
		"/css/**",
		"/js/**").permitAll()
	// Las vistas públicas no requieren autenticación
		.antMatchers("/",
		"/home",
		"/administrador/loginAdmin",
		"/visitas/**",
		"/propietarios/**",
		"/porteros/**").permitAll()
	// Todas las demás URLs de la Aplicación requieren autenticación
		.anyRequest().authenticated()
	// El formulario de Login no requiere autenticacion
		.and().formLogin().permitAll();
	}

	
}