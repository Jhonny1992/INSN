function uf_showError(titulo = 'Error', mensaje = 'Los sentimos, ha ocurrido un error') {
	swal(titulo, mensaje, 'error');
}

function uf_showAlert(titulo = 'Correcto', mensaje = 'Operación exitosa', type = 'success') {
	swal(titulo, mensaje, type);
}

//**********************************************************************
//Nombre: uf_createSpinner
//Funcion: Crea un spinner
//**********************************************************************
function uf_createSpinner(spinnerId, opts) {
	 var cfg = {
		 lines: opts['lines'] != null ? opts['lines'] : 12, // The number of lines to draw
		 length: opts['length'] != null ? opts['length'] : 7, // The length of each line
		 width: opts['width'] != null ? opts['width'] : 5, // The line thickness
		 radius: opts['radius'] != null ? opts['radius'] : 10, // The radius of the inner circle
		 scale: opts['scale'] != null ? opts['scale'] : 1.0, // Scales overall size of the spinner
		 corners: opts['corners'] != null ? opts['corners'] : 1, // Corner roundness (0..1)
		 color: opts['color'] != null ? opts['color'] : '#00ff00', // #rgb or #rrggbb or array of colors
		 opacity: opts['opacity'] != null ? opts['opacity'] : 0.25, // Opacity of the lines
		 rotate: opts['rotate'] != null ? opts['rotate'] : 0, // The rotation offset
		 direction: opts['direction'] != null ? opts['direction'] : 1, // 1: clockwise, -1: counterclockwise
		 speed: opts['speed'] != null ? opts['speed'] : 4, // Rounds per second
		 trail: opts['trail'] != null ? opts['trail'] : 100, // Afterglow percentage
		 fps: opts['fps'] != null ? opts['fps'] : 20, // Frames per second when using setTimeout() as a fallback for CSS
		 zIndex: opts['zIndex'] != null ? opts['zIndex'] : 2e9, // The z-index (defaults to 2000000000)
		 className: opts['className'] != null ? opts['className'] : 'spinner', // The CSS class to assign to the spinner
		 top: opts['top'] != null ? opts['top'] : '50%', // Top position relative to parent
		 left: opts['left'] != null ? opts['left'] : '50%', // Left position relative to parent
		 shadow: opts['shadow'] != null ? opts['shadow'] : true, // Whether to render a shadow
		 hwaccel: opts['hwaccel'] != null ? opts['hwaccel'] : false, // Whether to use hardware acceleration
		 position: opts['position'] != null ? opts['position'] : 'relative' // Element positioning
	 };
	
	 var target = $('<div/>', {
		 id: spinnerId,
		 class: 'col-sm-12 mb-5'
	 }).appendTo('.spinners');
	
	 return new Spinner(cfg).spin(target.get(0));
};

// **********************************************************************
// Nombre: ready
// Funcion: Seguimiento de peticiones ajax
// **********************************************************************
$(function () {
	var arrayRequest = [];
	
	$(document).ajaxStart(function (e, jqXHR, options) {
		window.console.log('Ajax start');
	});
	
	// Cada vez que se hace una petición
	$(document).ajaxSend(function (e, jqXHR, options) {
		let spin = $('[id*=spinner_id]');
		if (spin.length == 0) {
			var cfg = {
		     "lines": 12,
		     "top": "50%",
		     "right": "20%",
		     "position": "fixed"
		    };
				
			var id = 'spinner_id_' + Math.floor(1 + Math.random() * 999999);
			var spinner = uf_createSpinner(id, cfg);
			
			// Asociar el id y el spinner al request
			jqXHR.id = id;
			jqXHR.spinner = spinner;
		}
		
		window.console.log('Ajax send');
	});
	
	$(document).ajaxStop(function (e, jqXHR, options) {
		window.console.log('Ajax stop');
	});
	
	// Al completarse la petición
	$(document).ajaxComplete(function (e, jqXHR, options) {
		// Detener el spinner
		uf_stopSpinner(jqXHR);
		
		window.console.log('Ajax complete');
	});
	
	// Si ocurre error al realizar la petición
 	$(document).ajaxError(function (e, jqXHR, options) {
	     if (window.spinnerCtrl)
	         window.spinnerCtrl.spin(false);
	     window.console.log('Ajax error');
	 });
});

//**********************************************************************
//Nombre: uf_stopSpinner
//Funcion: Detiene el spinner asociado al request
//**********************************************************************
function uf_stopSpinner(jqXHR) {

 // Verificar si el request tiene spinner asociado
 if (jqXHR.spinner) {
     // Detener el spinner
     var el = jqXHR.spinner.spin(false).el;

     // Remover el div del spinner
     $('#' + jqXHR.id).remove();
 }
};

function validaEntero(input) {
	var reg = new RegExp('^\\d+$');

	return reg.test(input);
}