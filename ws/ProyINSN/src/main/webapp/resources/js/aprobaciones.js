$(function() {
	fInicializar();
});

function fInicializar() {
	fInicializarFechas();
	fConfigurarEventos();
	fCargarLista();
}

function fInicializarFechas() {
	var desde = moment().subtract(1, 'days').format('YYYY-MM-DD');
	var hasta = moment().format('YYYY-MM-DD');
	document.getElementById("desde").value = desde;
	document.getElementById("hasta").value = hasta
}

function fConfigurarEventos() {
	$('#estado').bind('change', function () {
		fCargarLista();
    });
	
	$('#btnBuscar').bind('click', function () {
		fCargarLista();
    });

    $('#btnLimpiar').bind('click', function () {
        $('#estado').val('');
        fInicializarFechas
        fCargarLista();
    });
}

function fCargarLista() {
	let estado = $('#estado').val();
	let desde = $('#desde').val();
	let hasta = $('#hasta').val();
	
	$.get('buscar', { estado: estado, desde: desde, hasta: hasta })
	.done(function (data) {
		fConfigurarGrilla(data);
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fConfigurarGrilla(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbRequerimiento';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = e['codRequerimiento'];
		r[1] = e['descripcion'];
		r[2] = e['unidadOrganica']['nombre'];
		r[3] = e['fechaEntrega'];
		r[4] = e['fechaRegistro'];
		r[5] = e['estado']['nombre'];
		r[6] = "<i title='observar' class='far fa-trash-alt fa-lg text-danger cursorHand' onclick=fEliminar(" + e['codRequerimiento'] + ")></i>";
		
		rows.push(r);
	});
	
	var jsonDT = {
		"language": JSON.parse(strJSON),
		"dom": "<'row'<'col-sm-12'tr>>" +
		       "<'row'<'col-lg-4'i><'col-lg-8'p>>" +
		       "<'row.text-center'<'col-sm-12'l>>",
        
        "responsive": true,
        "paging": true,
        "scrollY": "350px",
        "scrollCollapse": true,
        "scrollX": true,
        "info": true,
        "lengthChange": true,
        "lengthMenu": [[5, 10, 50, -1], ['5', '10', '50', 'Todo']],
        "destroy": true,
        "data": rows
	};
	
	window.tbRequerimiento = $('#' + tableId).DataTable(jsonDT);
}
