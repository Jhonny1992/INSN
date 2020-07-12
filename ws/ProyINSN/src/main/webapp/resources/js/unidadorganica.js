$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarFormulario();
	fConfigurarEventos();
	fCargarLista();
}

function fConfigurarEventos() {
	$('#txtNombreBusqueda').bind('keyup', function () {
		fCargarLista();
    });
	
	$('#btnBuscar').bind('click', function () {
		fCargarLista();
    });

    $('#btnLimpiar').bind('click', function () {
        $('#txtNombreBusqueda').val('');
        fCargarLista();
    });
    
    $('#modalUsuario').on('hide.bs.modal', function (e) {
    	fLimpiarFormulario();
    });
    
    $('#frmRegistro').bind('submit', frmRegistro_submit);
    
    $('#btnGrabar').bind('click', function() {
    	
    });
}

function fCargarLista() {
	let nombre = $('#txtNombreBusqueda').val();
	
	$.get('buscar', { nombre: nombre })
	.done(function (data) {
		fConfigurarGrilla(data);
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fConfigurarGrilla(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbUnidadOrganica';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = "<i title='editar' class='far fa-edit fa-lg text-warning cursorHand' onclick=fEditar(" + e['codUnidadOrganica']  + ")></i>";
		r[1] = e['codUnidadOrganica'];
		r[2] = e['nombre'];
		r[3] = e['descripcion'];
		r[4] = e['anexo'];
		r[5] = e['jefeEncargado'];
		r[6] = "<i title='eliminar' class='far fa-trash-alt fa-lg text-danger cursorHand' onclick=fEliminar(" + e['codUnidadOrganica'] + ")></i>";
		
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
        "lengthMenu": [[2, 10, 50, -1], ['2', '10', '50', 'Todo']],
        "destroy": true,
        "data": rows
	};
	
	window.tbUnidadOrganica = $('#' + tableId).DataTable(jsonDT);
}

function fEditar(id) {
	$.get('obtener', { id: id })
	.done(function (data) {
		console.log(data);
		
		$('#id').val(data.codUnidadOrganica);
		$('#nombre').val(data.nombre);
		$('#descripcion').val(data.descripcion);
		$('#anexo').val(data.anexo);
		$('#jefeEncargado').val(data.jefeEncargado);
		
		$('#modalUnidadOrganica .modal-title').html('Editar Unidad Organica');
		$('#btnGrabar').html('Actualizar');
		$('#modalUnidadOrganica').modal('show');
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fEliminar(id) {
	var jsonReq = {};
	jsonReq["type"] = 'post';
	jsonReq["async"] = true;
	jsonReq["url"] = 'eliminar';
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

function fAddUsuario() {
	
}

function fEditUnidadOrganica(reg) {
	$.post('actualizar', reg)
	.done(function (data) {
		fCargarLista();
		$('#modalUnidadOrganica').modal('hide');
		swal('Correcto', 'Se ha actualizado con éxito', 'success');
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fLimpiarFormulario() {
	$('#frmRegistro input').val('');
	window.validator.resetForm();
}

function frmRegistro_submit(e) {
    var isValid = $('#frmRegistro').valid();

    if (isValid) {
        e.preventDefault();
        
        var reg = {
        	codUnidadOrganica: $('#id').val(),
			nombre: $('#nombre').val(),
			descripcion: $('#descripcion').val(),
			anexo: $('#anexo').val(),
			jefeEncargado: $('#jefeEncargado').val()
    	};
        
    	if (reg.codUnidadOrganica == '')
    		fEditUnidadOrganica(reg);
    	else
    		fEditUnidadOrganica(reg);
    }
}

function fConfigurarFormulario() {
    window.validator = $("#frmRegistro").validate({
        rules: {
          nombres: {
              required: true,
              maxlength: 45
          },
          apellidos: {
              required: true,
              maxlength: 45
          },
          username: {
              required: true,
              minlength: 3,
              maxlength: 10
          },
          clave: {
              required: true,
              minlength: 6,
              maxlength: 15
          },
          correo: {
              required: true,
              maxlength: 30,
              email: true
          },
        },
        messages: {
            nombres: {
                required: "Debe ingresar nombre",
                maxlength: "Maximo {0} caracteres"
            },
            apellidos: {
                required: "Debe ingresar apellidos",
                maxlength: "Maximo {0} caracteres"
            },
            username: {
                required: "Debe ingresar usuario",
                minlength: "Debe tener al menos {0} caracteres",
                maxlength: "Máximo {0} caracteres"
            },
            clave: {
                required: "Debe ingresar clave",
                minlength: "Debe tener al menos {0} caracteres",
                maxlength: "Máximo {0} caracteres"
            },
            correo: {
                required: "Debe ingresar correo",
                maxlength: "Máximo {0} caracteres",
                email: "Ingrese un correo válido"
            },
        }
  });
}