<%@page import="com.ecosystems.entity.UsuarioBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-dark">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#"><i class="fas fa-bars"></i></a></li>
	</ul>
	<%if (session.getAttribute("usuario") == null) {%>
		<!-- Right navbar links -->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="<c:url value="/login/"/>" id="loginLink">Iniciar sesión</a></li>
		</ul>
	<%} else {%>
		<!-- Right navbar links -->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<li class="nav-item">
					<a class="nav-link">Hola <%((UsuarioBean)session.getAttribute("usuario")).getNombres();%>!</a>
				</li>
				
				<li class="nav-item"><a class="nav-link" href="<c:url value="/login/"/>" id="loginLink">Cerrar sesión</a></li>
			</li>
		</ul>
	<%} %>
</nav>