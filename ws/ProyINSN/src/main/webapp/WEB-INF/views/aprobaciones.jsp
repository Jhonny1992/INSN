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
							<div class="card-header p-1 bg-success text-white">
								<h4 class="text-center">Control de aprobaciones</h4>
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
																		<span class="input-group-text">Estado</span>
																	</div>
																	<select id="estadoBusqueda"
																		class="form-control form-control-sm">
																		<option value='0'>::: Todos :::</option>
																		<option value="1">Pendiente</option>
																		<option value="2">Observado</option>
																		<option value="3">Aprobado</option>
																	</select>
																</div>
															</div>
														</div>
														<div class="col-sm-12">
															<div class="form-group">
																<div class="input-group input-group-sm">
																	<div class="input-group-prepend">
																		<span class="input-group-text">Desde</span>
																	</div>
																	<input type="date" name="desde" id="desde" min="1900-01-01" max="3000-12-31" class="form-control">
																</div>
															</div>
														</div>
														<div class="col-sm-12">
															<div class="form-group">
																<div class="input-group input-group-sm">
																	<div class="input-group-prepend">
																		<span class="input-group-text">Hasta</span>
																	</div>
																	<input type="date" name="hasta" id="hasta" min="1900-01-01" max="3000-12-31" class="form-control">
																</div>
															</div>
														</div>
													</div>
													<div class="row">
									                	<div class="col-sm-12">
									                    	<input type="button" class="btn btn-sm btn-primary btn-block" value="Buscar" id="btnBuscar" name="btnBuscar" />
									                    	<input type="button" class="btn btn-sm btn-danger btn-block" value="Limpiar" id="btnLimpiar" name="btnLimpiar" />
									                	</div>
									            	</div>
												</form>
											</div>
										</div>
									</div>
									<div class="col-lg-9 col-md-8 col-sm-6">
										<table id="tbRequerimiento"
											class="table table-hover table-bordered display"
											style="width: 100%">
											<thead>
												<tr>
													<th>Id</th>
													<th>Descripcion</th>
													<th>Unidad orgánica</th>
													<th>Fecha entrega</th>
													<th>Fecha registro</th>
													<th>Estado</th>
													<th>Observación</th>
													<th>Detalle</th>
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
	
	<div class="modal fade" id="modalAprobacion" tabindex="-1" role="dialog" aria-labelledby="modalAprobacionLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form id="frmRegistro" autocomplete="off">
                    <div class="modal-header bg-info text-white p-2">
                        <h5 class="modal-title">Gestionar</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                        	<input type="hidden" id="id" name="id">
                            <div class="form-group col-md-6">
                                <label for="estado" class="col-form-label">Estado:</label>
                                <select id="estado"
									class="form-control form-control-sm">
									<option value="1">Pendiente</option>
									<option value="2">Observado</option>
									<option value="3">Aprobado</option>
								</select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="fechaEntrega" class="col-form-label">Fecha entrega:</label>
                                <input type="date" name="fechaEntrega" id="fechaEntrega" class="form-control">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="observacion" class="col-form-label">Observación:</label>
                                <textarea rows="3" maxlength="250" class="form-control" id="observacion" name="observacion"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        	<i class="fas fa-ban mr-1"></i>Cancelar
                        </button>
                        <button type="submit" class="btn btn-primary" id="btnGrabar">
                        	<i class="fas fa-save mr-1"></i>Grabar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="modalDetalle" tabindex="-1" role="dialog" aria-labelledby="modalDetalleLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
           		<div class="modal-header bg-info text-white p-2">
                    <h5 class="modal-title" id="exampleModalLabel">Detalle del requerimiento</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                	<div class="row">
                		<div class="col-md-12">
                       		<table id="tbDetRequerimiento" class="table table-sm table-hover table-bordered display" style="width: 100%">
							<thead>
								<tr>
									<th>Id</th>
									<th>Bien</th>
									<th>Tipo</th>
									<th>Cantidad</th>
									<th>Valor estimado</th>
								</tr>
							</thead>
							</table>
                       	</div>
                	</div>
                	<div class="row pt-2">
                		<div class="col-md-12 text-right">
                			<button type="button" class="btn btn-danger" data-dismiss="modal">
                				<i class="fas fa-ban mr-1"></i>Cerrar
                			</button>
                		</div>
                	</div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="include_scripts.jsp" />
<script type="text/javascript" src="../resources/js/aprobaciones.js"></script>
</html>
