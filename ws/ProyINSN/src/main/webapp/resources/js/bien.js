$(function() {
	//fInicializar();
});

function fInicializar() {
	fConfigurarGrilla();
	fCargarlistaBien();
}

function fConfigurarGrilla() {
	var strJSON = window.localStorage.getItem('dts');
	var tableId = 'tbBien';
	
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
        
        "paging": true,
        "scrollY": "350px",
        "scrollCollapse": true,
        "scrollX": true,
        
        "info": true,
        "lengthChange": true
		};
	window.tbUsuario = $('#' + tableId).DataTable();
}
//************************** buscar por fecha ************************\\
$(".btn-primary").click(function(){
	var fec1,fec2;
	fec1=$("#txtFecha1Busqueda").val();
	fec2=$("#txtFecha2Busqueda").val();
	
	$("#tbBien tbody").empty();
	$.getJSON("buscarXFecha",{ fechaInicio: fec1, fechaFin: fec2 },function(data){
		
		$.each(data,function(index,item){
		  $("#tbBien").append("<tr><td>"+item.codBien+"</td><td>"+
										item.nombre+"</td><td>"+
										item.descripcion+"</td><td>"+
										item.tipo+"</td><td>"+
										item.fechaRegistro+"</td><td>"+
										item.estado+"</td></tr>");	
		})
	})
	
	
})

//***************************


        
function reloadGrid() {
	$('#alertMessages').html('');
	window.tbMaestro.ajax.reload();
}

function fEditar(id) {
	window.location.href = 'Bien?op=5&id=' + id;
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