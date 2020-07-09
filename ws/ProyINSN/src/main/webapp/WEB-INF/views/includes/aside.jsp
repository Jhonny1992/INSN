<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<c:choose>
	<c:when test="${sessionScope.user != null}">
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

						<li class="nav-header">SEGURIDAD</li>
						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fas fa-circle"></i>
								<p>
									Usuarios <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a href="politicas" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Política de seguridad</p>
								</a></li>
								<li class="nav-item"><a href="usuarios" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Gestión de usuarios</p>
								</a></li>
								<li class="nav-item"><a href="bloqueos" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Bloqueos/Desbloqueos</p>
								</a></li>
							</ul></li>

						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fas fa-circle"></i>
								<p>
									Roles <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a href="roles" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Roles</p>
								</a></li>
								<li class="nav-item"><a href="asignacion" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Asignación de roles</p>
								</a></li>
								<li class="nav-item"><a href="permisos" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Accesos de rol</p>
								</a></li>
							</ul></li>

						<li class="nav-item has-treeview"><a href="#"
							class="nav-link"> <i class="nav-icon fas fa-circle"></i>
								<p>
									Accesos <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a href="modulos" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Módulo</p>
								</a></li>
								<li class="nav-item"><a href="recursos" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Recursos</p>
								</a></li>
								<li class="nav-item"><a href="operaciones" class="nav-link">
										<i class="far fa-circle nav-icon"></i>
										<p>Operaciones</p>
								</a></li>
							</ul></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

	</c:when>
	<c:otherwise>
		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="https://www.cibertec.edu.pe/" target="_blank"
				class="brand-link"> <img src="../resources/img/favicon.png"
				class="brand-image img-circle elevation-3" style="opacity: .8" /> <span
				class="brand-text font-weight-light">Proyecto INSN</span>
			</a>
		</aside>
	</c:otherwise>
</c:choose>
