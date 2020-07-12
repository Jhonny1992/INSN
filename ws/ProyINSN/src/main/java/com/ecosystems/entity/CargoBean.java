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
@Table(name = "cargo")
public class CargoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CargoBean() {
		super();
	}

	public CargoBean(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codCargo")
	private int codCargo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "cargo")
	@JsonIgnore
	private List<UsuarioBean> usuarios;

	public int getCodCargo() {
		return codCargo;
	}

	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}
	
}
