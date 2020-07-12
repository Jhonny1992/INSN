function uf_showError(titulo = 'Error', mensaje = 'Los sentimos, ha ocurrido un error') {
	swal(titulo, mensaje, 'error');
}

function uf_showAlert(titulo = 'Correcto', mensaje = 'Operación exitosa', type = 'success') {
	swal(titulo, mensaje, type);
}