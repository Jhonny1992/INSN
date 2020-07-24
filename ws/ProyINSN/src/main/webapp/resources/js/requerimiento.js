$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarFormulario();
	fConfigurarEventos();
	fCargarComboUnidadOrganica();
	fCargarListaDetalle();
}

function fConfigurarEventos() {
    $('#btnAgregarBien').bind('click', function() {
    	callback = function() {
    		$('#modalBien').modal('show').on('shown.bs.modal', fModalBien_shown);
    	}
    	
    	fCargarListaBien(callback);
    });
    
    $('#btnRemoverBienes').bind('click', function() {
    	var rows = window.tbDetalle.rows().count();
    	if (rows == 0) {
    		uf_showAlert('Advertencia', 'No hay ningún bien para eliminar', 'warning');
    		return;
    	}
    	
    	swal({
  		  title: "¿Está seguro de eliminar todos los bienes?",
  		  icon: "warning",
  		  buttons: ['Cancelar', 'Sí'],
  		  dangerMode: true,
  		})
  		.then((willDelete) => {
  			if (willDelete) {
  				$.post('eliminarTodoDetalle')
  				.done(function(data) {
  					fCargarListaDetalle();
  					uf_showAlert('Correcto', 'Eliminado con éxito');
  				})
  				.fail(function(data) {
  					uf_showError();
  				});
  		  } else {
  		    console.log('Se cancela eliminación')
  		  }
  		});
    });
    
    $('#nombreBienBuscar').bind('keyup', function () {
    	fCargarListaBien();
    });
    
    $('#frmRegistro').bind('submit', frmRegistro_submit);
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

function fCargarListaBien(callback) {
	let nombre = $('#nombreBienBuscar').val();
	
	$.get('listarBienes', { nombre: nombre })
	.done(function (data) {
		fConfigurarGrillaBien(data);
		
		if (callback != null)
			callback();
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fConfigurarGrillaBien(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbBien';
	
	var rows = [];
	data.map(function(e, i) {
		const codBien = parseInt(e['codBien']);
		const id_cantidad = 'cantidad_' + codBien;
		
		var r = [];
		r[0] = e['codBien'];
		r[1] = e['nombre'];
		r[2] = e['descripcion'];
		r[3] = e['tipoDesc'];
		r[4] = `<input type='number' id='${id_cantidad}' class='form-control form-control-sm' maxlength='3' style='width:100px' />`;
		r[5] = `<i title='agregar' class='fas fa-plus-circle fa-lg text-warning cursorHand' onclick='fAgregarBienTemp(${codBien}, "${id_cantidad}")';></i>`;
		
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

function fCargarListaDetalle() {
	$.get('listarDetalle')
	.done(function (data) {
		fConfigurarGrillaDetalle(data);
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fConfigurarGrillaDetalle(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbDetalle';
	
	var rows = [];
	data.map(function(e, i) {
		var r = [];
		r[0] = e['codBien'];
		r[1] = e['nombre'];
		r[2] = e['descripcion'];
		r[3] = e['tipoDesc'];
		r[4] = e['cantidad'];
		r[5] = "<i title='eliminar' class='far fa-trash-alt fa-lg text-danger cursorHand' onclick=fEliminarDetalle(" + e['codBien'] + ")></i>";
		
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
	
	window.tbDetalle = $('#' + tableId).DataTable(jsonDT);
}

function fModalBien_shown(e) {
    $.fn.dataTable.tables({ visible: true, api: true }).columns.adjust();
}

function fAgregarBienTemp(codBien, idCantidad) {
	var t = $('#' + idCantidad).val();
	
	if (t == '') {
		uf_showAlert('Advertencia', 'Debe ingresar cantidad', 'warning');
		return;
	}
	
	$.get('agregarBienTemp', { codBien: codBien, cantidad: parseInt(t) })
	.done(function (data) {
		fCargarListaBien();
		fCargarListaDetalle();
		uf_showAlert('Correcto', 'Agregado al detalle');
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fEliminarDetalle(codBien) {
	swal({
		  title: "¿Está seguro de retirar el bien?",
		  icon: "warning",
		  buttons: ['Cancelar', 'Sí'],
		  dangerMode: true,
		})
		.then((willDelete) => {
			if (willDelete) {
				$.post('eliminarDetalle',{codBien: codBien })
				.done(function(data) {
					fCargarListaDetalle();
					uf_showAlert('Correcto', 'Retirado con éxito');
				})
				.fail(function(data) {
					uf_showError();
				});
		  } else {
		    console.log('Se cancela eliminación')
		  }
		});
}

function frmRegistro_submit(e) {
    var isValid = $('#frmRegistro').valid();

    if (isValid) {
        e.preventDefault();
        
        var rows = window.tbDetalle.rows().count();
        if (rows == 0) {
    		uf_showAlert('Advertencia', 'Debe seleccionar por lo menos un bien', 'warning');
    		return;
    	}
        
        swal({
    		  title: "¿Está seguro de registrar el requerimiento?",
    		  icon: "warning",
    		  buttons: ['Cancelar', 'Sí'],
    		  dangerMode: true,
    		})
    		.then((confirma) => {
    			if (confirma) {
    				var reg = {
						codUnidadOrganica: $('#unidadOrganica').val(),
						descripcion: $('#descripcion').val()
			    	};

			        $.post('agregar', reg)
			    	.done(function (data) {
			    		uf_showAlert('Correcto', 'Registrado con éxito');
			    		fLimpiarFormulario();
			    		fCargarListaDetalle();
			    	})
			    	.fail(function(data) {
			    		uf_showError();
			    	});
    		  } else {
    		    console.log('Se cancela registro')
    		  }
		});
    }
}

function fLimpiarFormulario() {
	$('#frmRegistro textarea').val('');
	window.validator.resetForm();
}

function fConfigurarFormulario() {
    window.validator = $("#frmRegistro").validate({
        rules: {
          descripcion: {
              required: true,
              maxlength: 500
          },
          unidadOrganica: {
              required: true
          }
        },
        messages: {
            descripcion: {
                required: "Debe ingresar Descripción",
                maxlength: "Maximo {0} caracteres"
            },
            unidadOrganica: {
            	required: "Debe contar con unidad orgánica"
            }
        }
  });
}