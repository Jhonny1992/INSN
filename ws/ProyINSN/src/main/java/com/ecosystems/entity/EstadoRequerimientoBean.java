package com.ecosystems.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_requerimiento")
public class EstadoRequerimientoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EstadoRequerimientoBean(int codEstado, String nombre) {
		super();
		this.codEstado = codEstado;
		this.nombre = nombre;
	}
	
	public EstadoRequerimientoBean() {
		super();
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codEstado")
	private int codEstado;
	
	@Column(name = "nombre")
	private String nombre;

	public int getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
