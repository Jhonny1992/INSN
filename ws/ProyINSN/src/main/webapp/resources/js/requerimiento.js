$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarEventos();
	fCargarComboUnidadOrganica();
}

function fConfigurarEventos() {
    $('#btnAgregarBien').bind('click', function() {
    	let nombre = '';
    	
    	$.get('../bien/buscar', { nombre: nombre })
    	.done(function (data) {
    		fConfigurarGrillaBien(data);
    		
    		$('#modalBien').modal('show').on('shown.bs.modal', fModalBien_shown)
    	})
    	.fail(function(data) {
    		swal('Error', 'Los sentimos, ocurrió un error', 'error');
    	});
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

function fConfigurarGrillaBien(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbBien';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = e['codBien'];
		r[1] = e['nombre'];
		r[2] = e['descripcion'];
		r[3] = e['tipoDesc'];
		r[4] = "<input type='number' class='form-control form-control-sm' maxlength='3' style='width:100px' />";
		r[5] = "<i title='agregar' class='fas fa-plus-circle fa-lg text-warning cursorHand' onclick=fAgregarBienTemp(" + e['codBien'] + ")></i>";
		
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
	
	window.tbBien = $('#' + tableId).DataTable(jsonDT);
}

function fModalBien_shown(e) {
    $.fn.dataTable.tables({ visible: true, api: true }).columns.adjust();
}

function fAgregarBienTemp(codBien) {
	$.post('agregarBienTemp', { codbien: codBien })
	.done(function (data) {
		uf_showAlert('Correcto', 'Agregado al detalle');
	})
	.fail(function(data) {
		uf_showError();
	});
}