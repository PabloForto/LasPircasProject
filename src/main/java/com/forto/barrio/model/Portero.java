package com.forto.barrio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Porteros")
public class Portero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer documento;
	private String email;
	private String username;
	private String password;
	private String turno;
	private Date ingresoTurno;
	private Date egresoTurno;
	
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}
	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}
	/**
	 * @return the ingresoTurno
	 */
	public Date getIngresoTurno() {
		return ingresoTurno;
	}
	/**
	 * @param ingresoTurno the ingresoTurno to set
	 */
	public void setIngresoTurno(Date ingresoTurno) {
		this.ingresoTurno = ingresoTurno;
	}
	/**
	 * @return the egresoTurno
	 */
	public Date getEgresoTurno() {
		return egresoTurno;
	}
	/**
	 * @param egresoTurno the egresoTurno to set
	 */
	public void setEgresoTurno(Date egresoTurno) {
		this.egresoTurno = egresoTurno;
	}
	
	

}
