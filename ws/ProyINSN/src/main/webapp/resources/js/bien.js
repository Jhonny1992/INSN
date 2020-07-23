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
    
    $('#modalBien').on('hide.bs.modal', function (e) {
    	fLimpiarFormulario();
    });
    
    $('#btnAgregar').bind('click', function() {
    	$('#modalBien .modal-title').html('Agregar Bien');
		$('#btnGrabar').html('Registrar');
		$('#modalBien').modal('show');
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
		uf_showError();
	});
}

function fConfigurarGrilla(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbBien';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = "<i title='editar' class='far fa-edit fa-lg text-warning cursorHand' onclick=fEditar(" + e['codBien']  + ")></i>";
		r[1] = e['codBien'];
		r[2] = e['nombre'];
		r[3] = e['descripcion'];
		r[4] = e['tipoDesc'];
		r[5] = e['fechaRegistro'];
		r[6] = "<i title='eliminar' class='far fa-trash-alt fa-lg text-danger cursorHand' onclick=fEliminar(" + e['codBien'] + ")></i>";
		
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

function fEditar(id) {
	$.get('obtener', { id: id })
	.done(function (data) {
		console.log(data);
		
		$('#id').val(data.codBien);
		$('#nombre').val(data.nombre);
		$('#descripcion').val(data.descripcion);
		$('#tipo').val(data.tipo);
		$('#fechaRegistro').val(data.fechaRegistro);
				
		$('#modalBien .modal-title').html('Editar Bien');
		$('#btnGrabar').html('Actualizar');
		$('#modalBien').modal('show');
	})
	.fail(function(data) {
		uf_showError();
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

function fAddBien(reg) {
	$.post('agregar', reg)
	.done(function (data) {
		fCargarLista();
		$('#modalBien').modal('hide');
		uf_showAlert('Correcto', 'Registrado con éxito');
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fEditBien(reg) {
	$.post('actualizar', reg)
	.done(function (data) {
		fCargarLista();
		$('#modalBien').modal('hide');
		uf_showAlert('Correcto', 'Actualizado con éxito');
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fLimpiarFormulario() {
	$('#frmRegistro input, #tipo').val('');
	window.validator.resetForm();
}

function frmRegistro_submit(e) {
    var isValid = $('#frmRegistro').valid();

    if (isValid) {
        e.preventDefault();
        
        var reg = {
			codBien: $('#id').val(),
			nombre: $('#nombre').val(),
			descripcion: $('#descripcion').val(),
			tipo: $('#tipo').val()
    	};
        
    	if (reg.codBien == '')
    		fAddBien(reg);
    	else
    		fEditBien(reg);
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
              //required: true,
              maxlength: 500
          },
          tipo: {
              required: true
          },               
        },
        messages: {
            nombre: {
                required: "Debe ingresar nombre",
                maxlength: "Maximo {0} caracteres"
            },
            descripcion: {
                required: "Debe ingresar descripcion",
                maxlength: "Maximo {0} caracteres"
            },
            tipo: {
            	required: "Debe seleccionar tipo"
            }
       }
  });
}