$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarFormulario();
	fConfigurarEventos();
	fCargarLista();
	
	fCargarComboCargo();
}

function fConfigurarEventos() {
	$('#txtNombreBusqueda, #txtApellidoBusqueda').bind('keyup', function () {
		fCargarLista();
    });
	
	$('#btnBuscar').bind('click', function () {
		fCargarLista();
    });

    $('#btnLimpiar').bind('click', function () {
        $('#txtNombreBusqueda, #txtApellidoBusqueda').val('');
        fCargarLista();
    });
    
    $('#modalUsuario').on('hide.bs.modal', function (e) {
    	fLimpiarFormulario();
    });
    
    $('#btnAgregar').bind('click', function() {
    	$('#modalUsuario .modal-title').html('Agregar usuario');
		$('#btnGrabar').html('Registrar');
		$('#modalUsuario').modal('show');
    });
    
    $('#frmRegistro').bind('submit', frmRegistro_submit);
}

function fCargarLista() {
	let nombres = $('#txtNombreBusqueda').val();
	let apellidos = $('#txtApellidoBusqueda').val();
	
	$.get('buscar', { nombres: nombres, apellidos: apellidos })
	.done(function (data) {
		fConfigurarGrilla(data);
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fConfigurarGrilla(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbUsuario';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = "<i title='editar' class='far fa-edit fa-lg text-warning cursorHand' onclick=fEditar(" + e['codUsuario']  + ")></i>";
		r[1] = e['codUsuario'];
		r[2] = e['nombres'];
		r[3] = e['apellidos'];
		r[4] = e['nroDocumento'];
		r[5] = e['username'];
		r[6] = e['correo'];
		r[7] = e['cargo']['nombre'];
		r[8] = "<i title='eliminar' class='far fa-trash-alt fa-lg text-danger cursorHand' onclick=fEliminar(" + e['codUsuario'] + ")></i>";
		
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
	
	window.tbUsuario = $('#' + tableId).DataTable(jsonDT);
}

function fCargarComboCargo() {
	$.get('../cargo/listar')
	.done(function (data) {
		data.map(function(e, i){
			$('#cargo').append($('<option>', {
				value: e.codCargo,
				text: e.nombre
			}));
		});
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fEditar(id) {
	$.get('obtener', { id: id })
	.done(function (data) {
		console.log(data);
		
		$('#id').val(data.codUsuario);
		$('#nombres').val(data.nombres);
		$('#apellidos').val(data.apellidos);
		$('#dni').val(data.nroDocumento);
		$('#username').val(data.username);
		$('#clave').val(data.password);
		$('#correo').val(data.correo);
		$('#cargo').val(data.cargo.codCargo);
		$('#estado').prop('checked', data.estado);
		
		$('#modalUsuario .modal-title').html('Editar usuario');
		$('#btnGrabar').html('Actualizar');
		$('#modalUsuario').modal('show');
	})
	.fail(function(data) {
		uf_mostrarError();
	});
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

function fAddUsuario(reg) {
	$.post('agregar', reg)
	.done(function (data) {
		fCargarLista();
		$('#modalUsuario').modal('hide');
		uf_showAlert('Correcto', 'Registrado con éxito');
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fEditUsuario(reg) {
	$.post('actualizar', reg)
	.done(function (data) {
		fCargarLista();
		$('#modalUsuario').modal('hide');
		uf_showAlert('Correcto', 'Actualizado con éxito');
	})
	.fail(function(data) {
		uf_showError();
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
			codUsuario: $('#id').val(),
			nombres: $('#nombres').val(),
			apellidos: $('#apellidos').val(),
			dni: $('#dni').val(),
			username: $('#username').val(),
			clave: $('#clave').val(),
			correo: $('#correo').val(),
			codCargo: $('#cargo').val()
    	};
        
    	if (reg.codUsuario == '')
    		fAddUsuario(reg);
    	else
    		fEditUsuario(reg);
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
          dni: {
              required: true,
              minlength: 8,
              maxlength: 8,
              digits: true
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
          cargo: {
              required: true
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
            dni: {
                required: "Debe ingresar dni",
                minlength: "Debe tener {0} dígitos",
                maxlength: "Debe tener {0} dígitos",
                number: "Debe ingresar un dni válido"
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
            cargo: {
            	required: "Debe seleccionar cargo"
            }
        }
  });
}