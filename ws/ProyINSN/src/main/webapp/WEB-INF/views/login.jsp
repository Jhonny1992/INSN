<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="./includes/head.jsp" />
</head>
<body
	class="sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<jsp:include page="./includes/navbar.jsp" />
		<jsp:include page="./includes/aside.jsp" />
		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="container d-flex justify-content-center">
						<div class="transparent-form">
							<div class="card">
								<div class="card-header p-1 bg-info text-white">
									<h4 class="text-center">Iniciar sesión</h4>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-sm-12">
											<form action="Login" method="post" class="form" role="form"
												id="frmLogin">
												<div class="row">
													<div class="col-sm-12">
														<div class="form-group">
															<label for="usuario">Usuario</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"><i
																		class="fa fa-user"></i></span>
																</div>
																<input type="text" class="form-control" id="usuario"
																	name="usuario">
															</div>
															<label for="usuario" class="error text-danger"></label>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<div class="form-group">
															<label for="clave">Clave</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"><i
																		class="fa fa-lock"></i></span>
																</div>
																<input type="password" class="form-control" id="clave"
																	name="clave">
															</div>
															<label for="clave" class="error text-danger"></label>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<hr />
														<div class="form-group">
															<input type="submit" value="Ingresar"
																class="btn btn-primary btn-block" />
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</section>
		</div>
	</div>
</body>
<jsp:include page="./includes/scripts.jsp" />
</html>


