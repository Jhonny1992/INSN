$(function() {
	fInicializar();
});

function fInicializar() {
	//fConfigurarGrilla();
	fCargarLista();
}

function fCargarLista() {
	let nombres = $('#txtNombreBusqueda').val();
	let apellidos = $('#txtApellidoBusqueda').val();
	
	$.get('buscar', { nombres: nombres, apellidos: apellidos })
	.done(function (data) {
		fConfigurarGrilla(data);
		
		console.log(data);
		/*$('#tbUsuario tbody').html('');
		data.map(function(e, i) {
			$('#tbUsuario tbody').append('<tr>' +
											'<td>' + 'edit' + '</td>' +
											'<td>' + e.codUsuario + '</td>' +
											'<td>' + e.nombres + '</td>' +
											'<td>' + e.apellidos + '</td>' +
											'<td>' + e.username + '</td>' +
											'<td>' + e.correo + '</td>' +
											'<td>' + e.estado + '</td>' +
											'<td>' + 'del' + '</td>' +
										 '</tr>');
		});*/
	})
	.fail(function(data) {
		swal('Error', 'Los sentimo, ocurró un error', 'error');
	});
}

function fConfigurarGrilla(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbUsuario';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = "<i title='editar' class='far fa-edit text-warning cursorHand' onclick=fEditar(" + e['codUsuario']  + ")></i>";
		r[1] = e['codUsuario'];
		r[2] = e['nombres'];
		r[3] = e['apellidos'];
		r[4] = e['username'];
		r[5] = e['correo'];
		r[6] = e['estado'];
		r[7] = "<i title='eliminar' class='far fa-trash-alt text-danger cursorHand' onclick=fEliminar(" + e['codUsuario'] + ")></i>";
		
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
        "lengthMenu": [[2, 10, 50], [2, 10, 50]],
        "data": rows
	};
	
	window.tbUsuario = $('#' + tableId).DataTable(jsonDT);
}

function reloadGrid() {
	$('#alertMessages').html('');
	window.tbMaestro.ajax.reload();
}

function fEditar(id) {
	window.location.href = 'Usuario?op=5&id=' + id;
}

function fEliminar(id) {
	var jsonReq = {};
	jsonReq["type"] = 'post';
	jsonReq["async"] = true;
	jsonReq["url"] = 'Usuario';
	jsonReq["data"] = {'op': 6,
						'id': id
					};
	jsonReq["success"] = fEliminarSuccess;
	jsonReq["error"] = uf_ajaxRequestFailed;
	jsonReq["cache"] = false;
	jsonReq["processData"] = true;
	jsonReq['error'] = function (e) {
		uf_createAlert({ "element": $("#alertMessages"), "alertType": 'danger', "closable": true, "message": e });
    };

    var ajax = uf_ajaxRequest(jsonReq);
}