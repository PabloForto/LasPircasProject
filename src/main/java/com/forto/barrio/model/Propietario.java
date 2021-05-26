/**
 * Esta clase representa una entidad (un registro) en la tabla de Propietarios de la base de datos
 */
package com.forto.barrio.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*
 * Entidad Propietario con cardinalidad de uno a muchos a entidad Registro.
 */

@Entity
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	private String lote;
//	
//	private Integer numero;
	
	private String propiedad;
	
	private String nombre;
	
	private String apellido;
	
	private Integer documento;
	
	private String telefono;
	
	private String email;
	// categoria = propietario o inquilino.
	private String categoria;
	
	private String vehiculo;
	
	private String dominio;
	
	private String estatus;
	
	
	@OneToMany
	private List<Registro> registros;
	
	@OneToMany
	private List<Trabajador> trabajador;
	
	
		
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
//	 * @return the lote
//	 */
//	public String getLote() {
//		return lote;
//	}
//	
//	/**
//	 * @param lote the lote to set
//	 */
//	public void setLote(String lote) {
//		this.lote = lote;
//	}
//	
//	/**
//	 * @return the numero
//	 */
//	public Integer getNumero() {
//		return numero;
//	}
//	
//	/**
//	 * @param numero the numero to set
//	 */
//	public void setNumero(Integer numero) {
//		this.numero = numero;
//	}
	
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	/**
	 * @return the propiedad
	 */
	public String getPropiedad() {
		return propiedad;
	}

	/**
	 * @param propiedad the propiedad to set
	 */
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * @return the documento
	 */
	public Integer getDocumento() {
		return documento;
	}
	
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * @return the vehiculo
	 */
	public String getVehiculo() {
		return vehiculo;
	}
	
	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	/**
	 * @return the dominio
	 */
	public String getDominio() {
		return dominio;
	}
	
	/**
	 * @param dominio the dominio to set
	 */
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	

	public List<Registro> getRegistros() {
		return registros;
	}
	
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	

	/**
	 * @return the trabajador
	 */
	public List<Trabajador> getTrabajador() {
		return trabajador;
	}

	/**
	 * @param trabajador the trabajador to set
	 */
	public void setTrabajador(List<Trabajador> trabajador) {
		this.trabajador = trabajador;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", propiedad=" + propiedad + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", documento=" + documento + ", telefono=" + telefono + ", email=" + email + ", categoria="
				+ categoria + ", vehiculo=" + vehiculo + ", dominio=" + dominio + ", estatus=" + estatus
				+ ", registros=" + registros + ", trabajador=" + trabajador + "]";
	}

	
	
}
