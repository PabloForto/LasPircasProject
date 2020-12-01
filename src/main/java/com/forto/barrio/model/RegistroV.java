package com.forto.barrio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Entidad Registro con cardinalidad de Muchos a uno con entidad Visita.
 */

@Entity
public class RegistroV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date egreso;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ingreso;

	@ManyToOne
	private Visita visita;
	
	
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
	 * @return the registro
	 */
	public Date getRegistro() {
		return registro;
	}
	
	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(Date registro) {
		this.registro = registro;
	}
	
	/**
	 * @return the egreso
	 */
	public Date getEgreso() {
		return egreso;
	}
	
	/**
	 * @param egreso the egreso to set
	 */
	public void setEgreso(Date egreso) {
		this.egreso = egreso;
	}
	
	/**
	 * @return the ingreso
	 */
	public Date getIngreso() {
		return ingreso;
	}
	
	/**
	 * @param ingreso the ingreso to set
	 */
	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}
	
	/**
	 * @return the visita
	 */
	public Visita getVisita() {
		return visita;
	}
	
	/**
	 * @param visita the visita to set
	 */
	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	@Override
	public String toString() {
		return "RegistroV [id=" + id + ", registro=" + registro + ", egreso=" + egreso + ", ingreso=" + ingreso
				+ ", visita=" + visita + "]";
	}

	
	

}
