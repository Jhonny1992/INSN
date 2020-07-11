package com.ecosystems.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="unidadorganica")
public class UnidadOrganicaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codUnidad")
	private int codUnidadOrganica;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="anexo")
	private String anexo;
	
	
	//HACER JOIN.
	@Column(name="jefeEncargado")
	private int jefeEncargado;
	
	@Column(name="fechaRegistro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
		
	
	public UnidadOrganicaBean() {
		super();
	}


	public UnidadOrganicaBean(String nombre, String descripcion, String anexo, int jefeEncargado,
			Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.anexo = anexo;
		this.jefeEncargado = jefeEncargado;
		this.fechaRegistro = fechaRegistro;
	}


	public int getcodUnidadOrganica() {
		return codUnidadOrganica;
	}


	public void setcodUnidadOrganica(int codUnidadOrganica) {
		this.codUnidadOrganica = codUnidadOrganica;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getAnexo() {
		return anexo;
	}


	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}


	public int getJefeEncargado() {
		return jefeEncargado;
	}


	public void setJefeEncargado(int jefeEncargado) {
		this.jefeEncargado = jefeEncargado;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
	
	
}
