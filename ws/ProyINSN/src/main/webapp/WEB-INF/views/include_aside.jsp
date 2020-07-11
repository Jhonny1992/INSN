<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<c:choose>
	<c:when test="${sessionScope.user == null}">
		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="https://www.cibertec.edu.pe/" target="_blank"
				class="brand-link"> <img src="../resources/img/favicon.png"
				class="brand-image img-circle elevation-3" style="opacity: .8" /> <span
				class="brand-text font-weight-light">Proyecto INSN</span>
			</a>
		</aside>
	</c:when>
	<c:otherwise>
		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="<c:url value="/"/>" class="brand-link"> <img
				src="../resources/img/favicon.png"
				class="brand-image img-circle elevation-3" style="opacity: .8" /> <span
				class="brand-text font-weight-light">DAW 2</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<a> <i class="fas fa-user fa-2x"></i>
						</a>
					</div>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class with font-awesome or any other icon font library -->

						<li class="nav-header">Mis opciones</li>
						<li class="nav-item has-treeview">
							<a href="#" class="nav-link"><i class="nav-icon fas fa-circle"></i>
								<p>Mantenedores <i class="right fas fa-angle-left"></i></p>
							</a>
							<ul class="nav nav-treeview">
								<li class="nav-item">
									<a href="<c:url value="/usuario/"/>" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Usuarios</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="<c:url value="/bien/"/>" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Bienes</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="<c:url value="/unidadorganica/"/>" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Unidades orgánicas</p>
									</a>
								</li>
							</ul>
						</li>

						<li class="nav-item has-treeview">
							<a href="#" class="nav-link">
								<i class="nav-icon fas fa-circle"></i>
								<p>Procesos <i class="right fas fa-angle-left"></i></p>
							</a>
							<ul class="nav nav-treeview">
								<li class="nav-item">
									<a href="<c:url value="/donacion/"/>" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Gestión de requerimientos</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="<c:url value="/ordenCompra/"/>" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Consolidado anual</p>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>
	</c:otherwise>
</c:choose>
