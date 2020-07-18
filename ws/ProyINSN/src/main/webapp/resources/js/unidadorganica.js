$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarFormulario();
	fConfigurarEventos();
	fCargarLista();
	
	fCargarComboUsuario();
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
    
    $('#modalUnidadOrganica').on('hide.bs.modal', function (e) {
    	fLimpiarFormulario();
    });
    
    $('#btnAgregar').bind('click', function() {
    	$('#modalUnidadOrganica .modal-title').html('Agregar Unidad Organica');
		$('#btnGrabar').html('Registrar');
		$('#modalUnidadOrganica').modal('show');
    });
    
    $('#frmRegistro').bind('submit', frmRegistro_submit);
    
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
		r[5] = e['usuario']['nombres']+[" "]+ e['usuario']['apellidos'];
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
        "lengthMenu": [[5, 10, 50, -1], ['5', '10', '50', 'Todo']],
        "destroy": true,
        "data": rows
	};
	
	window.tbUnidadOrganica = $('#' + tableId).DataTable(jsonDT);
}

function fCargarComboUsuario() {
	$.get('../usuario/listar')
	.done(function (data) {
		data.map(function(e, i){
			$('#jefeEncargado').append($('<option>', {
				value: e.codUsuario,
				text: e.nombres +" "+ e.apellidos
			}));
		});
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fAddUnidadOrganica(reg) {
	$.post('agregar', reg)
	.done(function (data) {
		fCargarLista();
		$('#modalUnidadOrganica').modal('hide');
		uf_showAlert('Correcto', 'Registrado con éxito');
	})
	.fail(function(data) {
		uf_showError();
	});
}


function fEditar(id) {
	$.get('obtener', { id: id })
	.done(function (data) {
		console.log(data);
		
		$('#id').val(data.codUnidadOrganica);
		$('#nombre').val(data.nombre);
		$('#descripcion').val(data.descripcion);
		$('#anexo').val(data.anexo);
		$('#jefeEncargado').val(data.usuario.codUsuario);
		
		$('#modalUnidadOrganica .modal-title').html('Editar Unidad Organica');
		$('#btnGrabar').html('Actualizar');
		$('#modalUnidadOrganica').modal('show');
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fEliminar(id) {
	swal({
		  title: "¿Está seguro de eliminar el registro?",
		  icon: "warning",
		  buttons: ['Cancelar', 'Sí'],
		  dangerMode: true,
		})
		.then((willDelete) => {
			if (willDelete) {
				$.post('eliminar',{id: id })
				.done(function(data) {
					fCargarLista();
					uf_showAlert('Correcto', 'Eliminado con éxito');
				})
				.fail(function(data) {
					uf_showError();
				});
		  } else {
		    console.log('Se cancela eliminación')
		  }
		});
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
    		fAddUnidadOrganica(reg);
    	else
    		fEditUnidadOrganica(reg);
    }
}

function fConfigurarFormulario() {
    window.validator = $("#frmRegistro").validate({
        rules: {
          nombre: {
              required: true,
              maxlength: 90
          },
          descripcion: {
              required: true,
              maxlength: 250
          },
          anexo: {
              required: true,
              minlength:2,
              maxlength: 5
          },
          jefeEncargado:{
        	  required: true
          },
        },
        messages: {
            nombre: {
                required: "Debe ingresar nombre",
                maxlength: "Maximo {0} caracteres"
            },
            descripcion: {
                required: "Debe ingresar Descripción",
                maxlength: "Maximo {0} caracteres"
            },
            anexo: {
                required: "Debe ingresar Anexo",
                minlength: "Debe tener al menos {0} caracteres",
                maxlength: "Máximo {0} caracteres"
            },
            jefeEncargado: {
                required: "Debe seleccionar un Jefe Encargado",
            }
        }
  });
}