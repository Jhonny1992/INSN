package com.ecosystems.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToOne
	@JoinColumn(name="jefeEncargado")
	private UsuarioBean usuario;
	
	@Column(name="fechaRegistro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@OneToMany(mappedBy = "unidadOrganica")
	@JsonIgnore
	private List<RequerimientoBean> requerimientos;
	
	public UnidadOrganicaBean() {
		super();
	}


	public UnidadOrganicaBean(String nombre, String descripcion, String anexo,
			Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.anexo = anexo;
		this.fechaRegistro = fechaRegistro;
	}


	public int getCodUnidadOrganica() {
		return codUnidadOrganica;
	}


	public void setCodUnidadOrganica(int codUnidadOrganica) {
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


	public UsuarioBean getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public List<RequerimientoBean> getRequerimientos() {
		return requerimientos;
	}


	public void setRequerimientos(List<RequerimientoBean> requerimientos) {
		this.requerimientos = requerimientos;
	}
}
