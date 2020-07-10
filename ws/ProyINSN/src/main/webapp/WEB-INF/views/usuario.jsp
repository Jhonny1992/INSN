<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="include_head.jsp" />
</head>
<body
	class="sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed">
	<div class="wrapper">
		<jsp:include page="include_navbar.jsp" />
		<jsp:include page="include_aside.jsp" />
		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="container-fluid">
						<div class="card">
							<div class="card-header p-1 bg-info text-white">
								<h4 class="text-center">Mantenedor de usuarios</h4>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-sm-12">
										<div id="alertMessages" class="hiden"></div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-3 col-md-4 col-sm-6" id="contSearchPartial">
										
										
										<div class="card">
										    <div class="card-header p-1">
										        <h5 class="text-center">Filtro</h5>
										    </div>
										    <div class="card-body p-2">
										        <form>
										            <div class="row">
										                <div class="col-sm-12">
										                    <div class="form-group">
										                        <div class="input-group input-group-sm">
										                            <div class="input-group-prepend">
										                                <label for="txtNombreBusqueda" class="input-group-text"><i class="fa fa-search"></i></label>
										                            </div>
										                            <input type="text" class="form-control" placeholder="Ingrese nombres" id="txtNombreBusqueda" />
										                        </div>
										                    </div>
										                    <div class="form-group">
										                        <div class="input-group input-group-sm">
										                            <div class="input-group-prepend">
										                                <label for="txtApellidoBusqueda" class="input-group-text"><i class="fa fa-search"></i></label>
										                            </div>
										                            <input type="text" class="form-control" placeholder="Ingrese nombres" id="txtApellidoBusqueda" />
										                        </div>
										                    </div>
										                </div>
										            </div>
										            <div class="row">
										                <div class="col-sm-12">
										                    <input type="button" class="btn btn-sm btn-primary btn-block" value="Buscar" id="btnBuscar" name="btnBuscar" />
										                    <a href="crear" class="btn btn-sm btn-success btn-block">Agregar</a>
										                    <input type="button" class="btn btn-sm btn-danger btn-block" value="Limpiar" id="btnLimpiar" name="btnLimpiar" />
										                </div>
										            </div>
										        </form>
										    </div>
										</div>
										
									</div>
									<div class="col-lg-9 col-md-8 col-sm-6">
										<table id="tbProveedor"
											class="table table-hover table-bordered display"
											style="width: 100%">
											<thead>
												<tr>
													<th></th>
													<th>Id</th>
													<th>Nombres</th>
													<th>Apellidos</th>
													<th>Username</th>
													<th>Correo</th>
													<th>Estado</th>
													<th></th>
												</tr>
											</thead>
										</table>
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
<jsp:include page="include_scripts.jsp" />
</html>
