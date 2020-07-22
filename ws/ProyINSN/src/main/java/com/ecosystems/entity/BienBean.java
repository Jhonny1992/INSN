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
import javax.persistence.Transient;

import com.ecosystems.util.Constantes;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bien")
public class BienBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public BienBean(String nombre, String descripcion, int tipo, Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.fechaRegistro = fechaRegistro;
		
	}
	
	

	public BienBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codBien")
	private int codBien;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "tipo")
	private int tipo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaRegistro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaRegistro;
	

	// Otros campos descriptivos
	@Transient
	private String tipoDesc;

	public int getCodBien() {
		return codBien;
	}

	public void setCodBien(int codBien) {
		this.codBien = codBien;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipoDesc() {
		if (this.tipo == Constantes.COD_TIPO_BIEN_MATERIAL)
			this.tipoDesc = Constantes.DESC_TIPO_BIEN_MATERIAL;
		else
			this.tipoDesc = Constantes.DESC_TIPO_BIEN_SERVICIO;
		
		return this.tipoDesc;
	}
}
