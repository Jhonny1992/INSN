<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-dark">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#"><i class="fas fa-bars"></i></a></li>
	</ul>
	<c:choose>
		<c:when test="${sessionScope.user != null}">
			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<form action="Logout" id="logoutForm" method="post">
						<a class="nav-link"
							href="javascript:document.getElementById('logoutForm').submit()">Cerrar sesión</a>
					</form>
				</li>
			</ul>
		</c:when>
		<c:otherwise>
			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="Login" id="loginLink">Iniciar sesión</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>