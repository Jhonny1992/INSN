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
							<div class="card-header p-1 bg-primary text-white">
								<h4 class="text-center">Gestión de requerimientos</h4>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-sm-12">
										<div id="alertMessages" class="hiden"></div>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-6">
										<label for="unidadOrganica" class="col-form-label">Unidad orgánica:</label>
										<select id="unidadOrganica" name="unidadOrganica" class="form-control" disabled="disabled">
										</select>
									</div>
									<div class="form-group col-md-6">
                                		<label for="fechaRegistro" class="col-form-label">Fecha de registro:</label>
                                		<input type="text" class="form-control text-center" id="fechaRegistro" name="fechaRegistro" disabled="disabled">
                           			 </div>
                           			 <div class="form-group col-md-6">
                                		<label for="descripcion" class="col-form-label">Descripción:</label>
                                		<textarea rows="3" class="form-control" id="descripcion" name="descripcion"></textarea>
                           			 </div>
								</div>
								<div class="row mb-2">
                                     <div class="col-md-6">
                                         <div class="btn-toolbar mt-2">
                                             <div class="btn-group">
                                             	<button type="button" class="btn btn-outline-success" id="btnAgregarBien">Agregar bien</button>
                                             	<button type="button" class="btn btn-outline-danger" id="btnRemoverBienes">Remover bienes</button>
                                             </div>
                                         </div>
                                     </div>
                                 </div>
                                 <div class="row">
                                 	<div class="col-md-12">
                                 		<table id="tbUsuario"
											class="table table-sm table-hover table-bordered display"
											style="width: 100%">
											<thead>
												<tr>
													<th></th>
													<th>Id</th>
													<th>Bien</th>
													<th>Descripción</th>
													<th>Tipo</th>
													<th>Cantidad</th>
													<th></th>
												</tr>
											</thead>
										</table>
                                 	</div>
                                 </div>
                                 <div class="row">
                                 	<div class="col-md-12 text-center">
                                 		<button class="btn btn-primary">
                                 			<i class="fas fa-save pr-1"></i> Guardar
                                 		</button>
                                 	</div>
                                 </div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	
	<div class="modal fade" id="modalBien" tabindex="-1" role="dialog" aria-labelledby="modalBienLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header bg-info text-white p-2">
                    <h5 class="modal-title" id="exampleModalLabel">Lista de Bienes</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                	<div class="row">
                		<div class="col-md-12">
                       		<table id="tbUsuario" class="table table-sm table-hover table-bordered display" style="width: 100%">
							<thead>
								<tr>
									<th></th>
									<th>Id</th>
									<th>Bien</th>
									<th>Descripción</th>
									<th>Tipo</th>
									<th></th>
								</tr>
							</thead>
							</table>
                       	</div>
                	</div>
                	<div class="row">
                		<div class="col-md-12 text-center">
                			<button type="button" class="btn btn-info">
                				<i class="fas fa-check mr-1"></i>Seleccionar
                			</button>
                			<button type="button" class="btn btn-danger" data-dismiss="modal">
                				<i class="fas fa-ban mr-1"></i>Cancelar
                			</button>
                		</div>
                	</div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="include_scripts.jsp" />
<script type="text/javascript" src="../resources/js/requerimiento.js"></script>
</html>
