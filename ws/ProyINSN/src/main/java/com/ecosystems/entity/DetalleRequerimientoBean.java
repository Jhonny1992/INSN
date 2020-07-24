package com.ecosystems.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detallerequerimiento")
public class DetalleRequerimientoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codDetalleRequerimiento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codDetalleRequerimiento;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="valorEstimado")
	private double valorEstimado;
	
	@ManyToOne
	@JoinColumn(name="codRequerimiento")
	private RequerimientoBean requerimiento;
	@ManyToOne
	@JoinColumn(name="codBien")
	private BienBean bien;
	
	
	public DetalleRequerimientoBean() {
		super();
	}


	public DetalleRequerimientoBean(int cantidad, double valorEstimado, RequerimientoBean requerimiento,
			BienBean bien) {
		super();
		this.cantidad = cantidad;
		this.valorEstimado = valorEstimado;
		this.requerimiento = requerimiento;
		this.bien = bien;
	}


	public int getCodDetalleRequerimiento() {
		return codDetalleRequerimiento;
	}


	public void setCodDetalleRequerimiento(int codDetalleRequerimiento) {
		this.codDetalleRequerimiento = codDetalleRequerimiento;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getValorEstimado() {
		return valorEstimado;
	}


	public void setValorEstimado(double valorEstimado) {
		this.valorEstimado = valorEstimado;
	}


	public RequerimientoBean getRequerimiento() {
		return requerimiento;
	}


	public void setRequerimiento(RequerimientoBean requerimiento) {
		this.requerimiento = requerimiento;
	}


	public BienBean getBien() {
		return bien;
	}


	public void setBien(BienBean bien) {
		this.bien = bien;
	}
	
	
	
	
	

}
