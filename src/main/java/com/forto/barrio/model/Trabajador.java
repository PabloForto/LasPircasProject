package com.forto.barrio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trabajador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_trabajador;
	
	private String nombre;
	
	private String apellido;
	
	private String documento;
	
	private String categoria;
	
	private String imagen = "no-image.png";
	
	private String documentacion;
	
//	private String lote;
//	
//	private String numero;
	
	private String propiedad;
	
	@ManyToOne
	private Propietario propietarios;
	
	
	/**
	 * @return the id_trabajador
	 */
	public Integer getId_trabajador() {
		return id_trabajador;
	}
	
	/**
	 * @param id_trabajador the id_trabajador to set
	 */
	public void setId_trabajador(Integer id_trabajador) {
		this.id_trabajador = id_trabajador;
	}
	
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
	public String getDocumento() {
		return documento;
	}
	
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	/**
	 * @return the documentacion
	 */
	public String getDocumentacion() {
		return documentacion;
	}
	
	/**
	 * @param documentacion the documentacion to set
	 */
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
		
	/**
	 * @return the propietarios
	 */
	public Propietario getPropietarios() {
		return propietarios;
	}
	
	/**
	 * @param propietarios the propietarios to set
	 */
	public void setPropietarios(Propietario propietarios) {
		this.propietarios = propietarios;
	}
	
	
//	/**
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
//	public String getNumero() {
//		return numero;
//	}
//	
//	/**
//	 * @param numero the numero to set
//	 */
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}
	
	
	public void reset() {
		this.imagen= null;
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

	@Override
	public String toString() {
		return "Trabajador [id_trabajador=" + id_trabajador + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", documento=" + documento + ", categoria=" + categoria + ", imagen=" + imagen + ", documentacion="
				+ documentacion + ", propiedad=" + propiedad + ", propietarios=" + propietarios + "]";
	}




	
	
	
	

}
