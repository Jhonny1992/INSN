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
										                            <input type="text" class="form-control" placeholder="Ingrese apellidos" id="txtApellidoBusqueda" />
										                        </div>
										                    </div>
										                </div>
										            </div>
										            <div class="row">
										                <div class="col-sm-12">
										                    <input type="button" class="btn btn-sm btn-primary btn-block" value="Buscar" id="btnBuscar" name="btnBuscar" />
										                    <input type="button" class="btn btn-sm btn-success btn-block" value="Agregar" id="btnAgregar" name="btnAgregar" />
										                    <input type="button" class="btn btn-sm btn-danger btn-block" value="Limpiar" id="btnLimpiar" name="btnLimpiar" />
										                </div>
										            </div>
										        </form>
										    </div>
										</div>
										
									</div>
									<div class="col-lg-9 col-md-8 col-sm-6">
										<table id="tbUsuario"
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
	
	<div class="modal fade" id="modalUsuario" tabindex="-1" role="dialog" aria-labelledby="modalUsuarioLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form id="frmRegistro" autocomplete="off">
                    <div class="modal-header bg-info text-white p-2">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                        	<input type="hidden" id="id" name="id">
                            <div class="form-group col-md-6">
                                <label for="nombres" class="col-form-label">Nombres:</label>
                                <input type="text" class="form-control" id="nombres" name="nombres">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="apellidos" class="col-form-label">Apellidos:</label>
                                <input type="text" class="form-control" id="apellidos" name="apellidos">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="dni" class="col-form-label">Dni:</label>
                                <input type="text" class="form-control" id="dni" name="dni">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="username" class="col-form-label">Usuario:</label>
                                <input type="text" class="form-control" id="username" name="username">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="clave" class="col-form-label">Clave:</label>
                                <input type="text" class="form-control" id="clave" name="clave">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="clave" class="col-form-label">Correo:</label>
                                <input type="text" class="form-control" id="correo" name="correo">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="cargo" class="col-form-label">Cargo:</label>
                                <select id="cargo" name="cargo" class="form-control">
                                	<option value=''>::: Seleccione :::</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6 text-right">
                            	<label for="clave" class="col-form-label"> </label>
							    <div class="form-check">
							    	<input class="form-check-input" type="checkbox" id="estado">
							    	<label class="form-check-label" for="estado">Activo</label>
							    </div>
						  </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary" id="btnGrabar"></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<jsp:include page="include_scripts.jsp" />
<script type="text/javascript" src="../resources/js/usuario.js"></script>
</html>
