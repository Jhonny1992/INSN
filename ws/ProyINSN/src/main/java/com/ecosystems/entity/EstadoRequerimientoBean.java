package com.ecosystems.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(mappedBy = "estado")
	@JsonIgnore
	private List<RequerimientoBean> requerimientos;

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

	public List<RequerimientoBean> getRequerimientos() {
		return requerimientos;
	}

	public void setRequerimientos(List<RequerimientoBean> requerimientos) {
		this.requerimientos = requerimientos;
	}

}
