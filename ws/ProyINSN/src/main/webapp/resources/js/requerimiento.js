$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarEventos();
	//fCargarLista();
}

function fConfigurarEventos() {
    $('#btnAgregarBien').bind('click', function() {
		$('#modalBien').modal('show');
    });
}
