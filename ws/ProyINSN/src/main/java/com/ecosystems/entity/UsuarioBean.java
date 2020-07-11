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
@Table(name = "usuario")
public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario")
	private int codUsuario;
	
	@Column(name = "nom_usua")
	private String nombres;
	
	@Column(name = "ape_usua")
	private String apellidos;
	
	@Column(name = "login")
	private String username;
	
	@Column(name = "clave")
	private String password;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "fec_reg")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@Column(name = "estado")
	private boolean estado;
	
	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioBean(String apellidos, String nombres, String username, String password, String correo,
			Date fechaRegistro, boolean estado) {
		super();
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.username = username;
		this.password = password;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
