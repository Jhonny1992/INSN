<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
								<h4 class="text-center">Mantenedor de Unidad Organica</h4>
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
										                            <input type="text" class="form-control" placeholder="Ingrese nombre" id="txtNombreBusqueda" />
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
										<table id="tbUnidadOrganica"
											class="table table-hover table-bordered display"
											style="width: 100%">
											<thead>
												<tr>
													<th></th>
													<th>Id</th>
													<th>Nombre</th>
													<th>Descripcion</th>
													<th>Anexo</th>
													<th>JefeEncargado</th>
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
	
	<div class="modal fade" id="modalUnidadOrganica" tabindex="-1" role="dialog" aria-labelledby="modalUsuarioLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
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
                                <label for="nombres" class="col-form-label">Nombre:</label>
                                <input type="text" class="form-control" id="nombre" name="nombre">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="apellidos" class="col-form-label">Descripcion:</label>
                                <textarea rows="3" class="form-control" id="descripcion" name="descripcion"></textarea>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="username" class="col-form-label">Anexo:</label>
                                <input type="text" class="form-control" id="anexo" name="anexo">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="jefeEncargado" class="col-form-label">Jefe Encargado:</label>
                                <select id="jefeEncargado" name="jefeEncargado" class="form-control">
                                	<option value=''>::: Seleccione :::</option>
                                </select>
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
<script type="text/javascript" src="../resources/js/unidadorganica.js"></script>
</html>
