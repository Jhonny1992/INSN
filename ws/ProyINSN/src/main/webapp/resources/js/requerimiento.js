$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarEventos();
	fCargarComboUnidadOrganica();
}

function fConfigurarEventos() {
    $('#btnAgregarBien').bind('click', function() {
		$('#modalBien').modal('show');
    });
}

function fCargarComboUnidadOrganica() {
	$.get('unidadOrgánicaXUsuario')
	.done(function (data) {
		$('#unidadOrganica').append($('<option>', {
			value: data.codUnidadOrganica,
			text: data.nombre
		}));
	})
	.fail(function(data) {
		uf_showError();
	});
}