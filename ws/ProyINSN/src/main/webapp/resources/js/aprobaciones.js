$(function() {
	fInicializar();
});

function fInicializar() {
	fConfigurarFormulario();
	fInicializarFechas();
	fConfigurarEventos();
	fCargarLista();
}

function fInicializarFechas() {
	var desde = moment().subtract(1, 'days').format('YYYY-MM-DD');
	var hasta = moment().format('YYYY-MM-DD');
	document.getElementById("desde").value = desde;
	document.getElementById("hasta").value = hasta
	
	document.getElementById("fechaEntrega").value = hasta
}

function fConfigurarEventos() {
	$('#estadoBusqueda').bind('change', function () {
		fCargarLista();
    });
	
	$('#btnBuscar').bind('click', function () {
		fCargarLista();
    });

    $('#btnLimpiar').bind('click', function () {
        $('#estadoBusqueda').val('0');
        fInicializarFechas();
        fCargarLista();
    });
    
    $('#modalAprobacion').on('hide.bs.modal', function (e) {
    	fLimpiarFormulario();
    });
    
    $('#frmRegistro').bind('submit', frmRegistro_submit);
}

function fCargarLista() {
	let estado = $('#estadoBusqueda').val();
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
		r[6] = e['observacion'];
		r[7] = "<i title='ver detalle' class='far fa-eye fa-lg text-danger cursorHand' onclick=fVerDetalle(" + e['codRequerimiento'] + ")></i>";
		r[8] = "<i title='gestionar' class='fas fa-check-circle fa-lg text-primary cursorHand' onclick=fGestionar(" + e['codRequerimiento'] + ")></i>";
		
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

function fGestionar(codRequerimiento) {
	$.get('obtener', { codRequerimiento: codRequerimiento })
	.done(function (data) {
		var fechaEntrega = moment(data.fechaEntrega, 'DD/MM/YYYY');
		
		$('#id').val(data.codRequerimiento);
		$('#estado').val(data.estado.codEstado);
		//$('#fechaEntrega').val(fechaEntrega);
		document.getElementById("fechaEntrega").value
		$('#observacion').val(data.observacion);
		
		$('#modalAprobacion').modal('show');
	})
	.fail(function(data) {
		uf_showError();
	});
}

function fLimpiarFormulario() {
	$('#frmRegistro input, textarea').val('');
	window.validator.resetForm();
}

function frmRegistro_submit(e) {
    var isValid = $('#frmRegistro').valid();

    if (isValid) {
        e.preventDefault();
        
        var reg = {
			codRequerimiento: $('#id').val(),
			estado: $('#estado').val(),
			fechaEntrega: $('#fechaEntrega').val(),
			observacion: $('#observacion').val()
    	};
        
        $.post('actualizar', reg)
    	.done(function (data) {
    		fCargarLista();
    		$('#modalAprobacion').modal('hide');
    		uf_showAlert('Correcto', 'Actualizado con éxito');
    	})
    	.fail(function(data) {
    		uf_showError();
    	});
    }
}

function fVerDetalle(codRequerimiento) {
	let callback = function() {
		$('#modalDetalle').modal('show').on('shown.bs.modal', fModalDetRequerimiento_shown);
	}
	
	fCargarListaDetalle(codRequerimiento, callback);
}

function fCargarListaDetalle(codRequerimiento, callback) {
	$.get('listarDetalle', { codRequerimiento: codRequerimiento })
	.done(function (data) {
		fConfigurarGrillaDetalle(data);
		callback();
	})
	.fail(function(data) {
		swal('Error', 'Los sentimos, ocurrió un error', 'error');
	});
}

function fConfigurarGrillaDetalle(data) {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbDetRequerimiento';
	
	var rows = [];
	data.map(function(e, i) {
		const codDetRequerimiento = parseInt(e['codDetalleRequerimiento']);
		const id_valor = 'valor_' + codDetRequerimiento;
		
		var r = [];
		r[0] = e['codDetalleRequerimiento'];
		r[1] = e['bien']['nombre'];
		r[2] = '';
		r[3] = e['cantidad'];
		r[4] = `<input type='number' min='1' max='99999' id='${id_valor}' class='form-control form-control-sm' maxlength='6' style='width:100px' />`;
		
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
	
	window.tbDetRequerimiento = $('#' + tableId).DataTable(jsonDT);
}

function fModalDetRequerimiento_shown(e) {
    $.fn.dataTable.tables({ visible: true, api: true }).columns.adjust();
}

function fConfigurarFormulario() {
    window.validator = $("#frmRegistro").validate({
        rules: {
        	estado: {
              required: true
          },
          observacion: {
              required: true,
              maxlength: 250
          }
        },
        messages: {
        	estado: {
                required: "Debe ingresar nombre"
            },
            observacion: {
                required: "Debe ingresar observación",
                maxlength: "Maximo {0} caracteres"
            }
        }
  });
}