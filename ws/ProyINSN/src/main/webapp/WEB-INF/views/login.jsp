<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charse=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ingreso al sistema</title>
<link rel="shortcut icon" type="image/x-icon"
	href="../resources/img/favicon.ico" />
<link rel="stylesheet"
	href="../resources/libs/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../resources/libs/font-awesome-5-css/css/all.min.css">

<style>
.error {
	color: red;
}
</style>

</head>
<body>
	<div class="container d-flex justify-content-center">
		<div class="transparent-form">
			<div class="card">
				<div class="card-header p-1 bg-info text-white">
					<h4 class="text-center">Iniciar sesión</h4>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-sm-12">
							<form action="">
								<div class="row">
									<div class="col-sm-12">
										<label for="txtUsuario" class="col-form-label">Usuario:</label>
										<input type="text" class="form-control" id="txtUsuario"
											name="txtUsuario"> <span class="error"
											for="txtUsuario"></span>
									</div>
								</div>
							</form>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<form action="">
								<div class="row">
									<div class="col-sm-12">
										<label for="txtContrasena" class="col-form-label">Contrasena:</label>
										<input type="text" class="form-control" id="txtContrasena"
											name="txtContrasena"> <span class="error"
											for="txtContrasena"></span>
									</div>
								</div>
							</form>
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
				</div>
			</div>
		</div>
	</div>
</body>

<script src="../resources/libs/jquery/dist/jquery.min.js"></script>
<script src="../resources/libs/popperjs/umd/popper.min.js"></script>
<script
	src="../resources/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="../resources/libs/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</html>