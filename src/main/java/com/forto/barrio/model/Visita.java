package com.forto.barrio.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Visita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
    private String apellido;
    private Integer documento;
    private String vehiculo;
    private String dominio;
    private String lote;
    private Integer numero;
    // categoria = visita o flete
    private String categoria;
    // estatus(1=particular,2=materiales,3=encomienda)
    private String estatus;
	
   
    @OneToMany
    private List<Registro> registros;
	
       
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
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	
	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	
	public List<Registro> getResgistros() {
		return registros;
	}
	
	public void setResgistros(List<Registro> resgistros) {
		this.registros = resgistros;
	}

	
   
    
}
