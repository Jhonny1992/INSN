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
@Table(name = "usuario")
public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codUsuario")
	private int codUsuario;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "nroDocumento")
	private String nroDocumento;
	
	@Column(name = "login")
	private String username;
	
	@Column(name = "clave")
	private String password;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@JoinColumn(name = "codCargo")
	@ManyToOne
	private CargoBean cargo;
	
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<UnidadOrganicaBean> unidadOrganica;
	

	public UsuarioBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioBean(String apellidos, String nombres, String username, String password, String correo,
			Date fechaRegistro) {
		super();
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.username = username;
		this.password = password;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
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
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
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

	public CargoBean getCargo() {
		return cargo;
	}

	public void setCargo(CargoBean cargo) {
		this.cargo = cargo;
	}

	public List<UnidadOrganicaBean> getUnidadOrganica() {
		return unidadOrganica;
	}

	public void setUnidadOrganica(List<UnidadOrganicaBean> unidadOrganica) {
		this.unidadOrganica = unidadOrganica;
	}
	
	
	
	
}
