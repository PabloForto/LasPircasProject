/**
 * Esta clase representa una entidad (un registro) en la tabla de Registro de ingresos y egresos de los propietarios de la base de datos
 */
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
 * Entidad Registro con cardinalidad de muchos a uno con entidad Propietario.
 */

@Entity
public class Registro {

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
	private Propietario propietario;
	

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
	 * @return the propietario
	 */
	public Propietario getPropietario() {
		return propietario;
	}
	
	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", registro=" + registro + ", egreso=" + egreso + ", ingreso=" + ingreso
				+ ", propietario=" + propietario + "]";
	}
	
	
	
	
}
