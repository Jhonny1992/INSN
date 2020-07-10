$(function() {
	fInicializar();
});

function fInicializar() {
	//fConfigurarGrilla();
	swal("Bienvenido!", "Mantenedor de usuarios!", "success");
}

function fConfigurarGrilla() {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbUsuario';
	
	var editIcon = function (data, type, row, meta) {
		return "<i title='editar' class='far fa-edit cursorHand' onclick=fEditar(" + row.usuarioId  + ")></i>";
	};
	
	var deleteIcon = function (data, type, row, meta) {
		return "<i title='eliminar' class='far fa-trash-alt cursorHand' onclick=fEliminar(" + row.usuarioId + ")></i>";
	};
	
	var jsonDT = {
		"language": JSON.parse(strJSON),
		"dom": "<'row'<'col-sm-12'tr>>" +
		       "<'row'<'col-lg-4'i><'col-lg-8'p>>" +
		       "<'row.text-center'<'col-sm-12'l>>",
        
        "responsive": true,
		"searching": false,
		"ordering": false,
		"order": [[1, "asc"]],
		"info": true,
		"stateSave": false,
        "fixedColumns":   {
            "heightMatch": 'none'
        },
        "scrollY": "350px",
        "scrollCollapse": true,
        "scrollX": true,
        "buttons": true,
        "search": {
            "search": "",
            "caseInsensitive": true,
            "smart": false
        },
        "paging": true,
        "lengthChange": true,
        "lengthMenu": [[5, 10, 50], [5, 10, 50]],
        "pagingType": "full_numbers", // [number | simple | full | full_numbers | first_last_numbers]
        
        "columns": [
        	{ "data": "edit", "name": "edit", "width": "5%", "className": "text-center", "autoWidth": false, "orderable": false, render: editIcon },
        	{ "data": "codUsuario", "name": "codUsuario", "width": "5%", "className": "text-center", "autoWidth": false },
        	{ "data": "nombreCompleto", "name": "nombreCompleto", "width": "35%", "className": "text-center", "autoWidth": false },
        	{ "data": "usuario", "name": "usuario", "width": "5%", "className": "text-center", "autoWidth": false },
        	{ "data": "correo", "name": "correo", "width": "20%", "className": "text-center", "autoWidth": false },
        	{ "data": "estadoDesc", "name": "estadoDesc", "width": "5%", "className": "text-center", "autoWidth": false },
        	{ "data": "delete", "name": "delete", "width": "5%", "className": "text-center", "autoWidth": false, "orderable": false, render: deleteIcon }
        ],
        
        "processing": false,
        "serverSide": false,
        "filter": false,
        "orderMulti": false
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