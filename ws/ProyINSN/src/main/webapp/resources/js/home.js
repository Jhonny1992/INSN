document.addEventListener('DOMContentLoaded', () => {
    try {
        uf_obtenerValores();
    } catch (e) {
        window.console.log(e.toString());
    }
});

function uf_obtenerValores() {
    var json;

    var dts = window.localStorage.getItem('dts');

    if (dts == null)
    {
        var jqxhr = $.getJSON("../resources/libs/DataTables/Intl/DataTables.spanish.json")
        .done(function (data) {
        	window.localStorage.setItem('dts', JSON.stringify(data));
            console.log("second success");
        })
        .fail(function (data) {
            console.log("error");
        })
        .always(function () {
            console.log("complete");
        });
    }
}