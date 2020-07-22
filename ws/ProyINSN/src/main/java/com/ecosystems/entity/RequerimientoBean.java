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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "requerimiento")
public class RequerimientoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RequerimientoBean(int codRequerimiento, String descripcion, UnidadOrganicaBean codUnidad, Date fechaEntrega,
			Date fechaRegistro, EstadoRequerimientoBean estado) {
		super();
		this.codRequerimiento = codRequerimiento;
		this.descripcion = descripcion;
		this.codUnidad = codUnidad;
		this.fechaEntrega = fechaEntrega;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}
	
	public RequerimientoBean() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codRequerimiento")
	private int codRequerimiento;
	
	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name="codUnidad")
	private UnidadOrganicaBean codUnidad;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaEntrega")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaEntrega;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaRegistro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name="estado")
	private EstadoRequerimientoBean estado;
	
	@OneToMany(mappedBy="requerimiento")
	private List<DetalleRequerimientoBean> detalleRequerimiento;
	

	public int getCodRequerimiento() {
		return codRequerimiento;
	}

	public void setCodRequerimiento(int codRequerimiento) {
		this.codRequerimiento = codRequerimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadOrganicaBean getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(UnidadOrganicaBean codUnidad) {
		this.codUnidad = codUnidad;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public EstadoRequerimientoBean getEstado() {
		return estado;
	}

	public void setEstado(EstadoRequerimientoBean estado) {
		this.estado = estado;
	}

	public List<DetalleRequerimientoBean> getDetalleRequerimiento() {
		return detalleRequerimiento;
	}

	public void setDetalleRequerimiento(List<DetalleRequerimientoBean> detalleRequerimiento) {
		this.detalleRequerimiento = detalleRequerimiento;
	}	

	
	
}
