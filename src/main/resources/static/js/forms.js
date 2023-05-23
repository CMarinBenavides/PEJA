//Funciones para mostrar alertas de validación de campos de Administradores

//funcion focus y blur para el campo cedulaAdmin
var inputCedulaAdmin = document.getElementById("cedulaAdmin");
if (inputCedulaAdmin != null) {
    inputCedulaAdmin.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniAdmin = document.getElementById("alertDangerDniAdmin");
        alertDangerDniAdmin.style.display = "none";

        var alertInfoDniAdmin = document.getElementById("alertInfoDniAdmin");
        alertInfoDniAdmin.style.display = "block";
    };
    inputCedulaAdmin.onblur = function () {
        if (inputCedulaAdmin.value == "") {
            var alertDangerDniAdmin = document.getElementById("alertDangerDniAdmin");
            alertDangerDniAdmin.style.display = "block";
        }
        var alertInfoDniAdmin = document.getElementById("alertInfoDniAdmin");
        alertInfoDniAdmin.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreAdmin
var inputNombreAdmin = document.getElementById("nombreAdmin");
if (inputNombreAdmin != null) {
    inputNombreAdmin.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreAdmin = document.getElementById(
            "alertDangerNombreAdmin"
        );
        alertDangerNombreAdmin.style.display = "none";
    };
    inputNombreAdmin.onblur = function () {
        if (inputNombreAdmin.value == "") {
            var alertDangerNombreAdmin = document.getElementById(
                "alertDangerNombreAdmin"
            );
            alertDangerNombreAdmin.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoAdmin
var inputApellidoAdmin = document.getElementById("apellidoAdmin");
if (inputApellidoAdmin != null) {
    inputApellidoAdmin.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoAdmin = document.getElementById(
            "alertDangerApellidoAdmin"
        );
        alertDangerApellidoAdmin.style.display = "none";
    };
    inputApellidoAdmin.onblur = function () {
        if (inputApellidoAdmin.value == "") {
            var alertDangerApellidoAdmin = document.getElementById(
                "alertDangerApellidoAdmin"
            );
            alertDangerApellidoAdmin.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoAdmin
var inputCorreoAdmin = document.getElementById("correoAdmin");
if (inputCorreoAdmin != null) {
    inputCorreoAdmin.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoAdmin = document.getElementById("alertDangerCorreoAdmin");
        alertDangerCorreoAdmin.style.display = "none";

        var alertInfoCorreoAdmin = document.getElementById(
            "alertInfoCorreoAdmin"
        );
        alertInfoCorreoAdmin.style.display = "block";
    };
    inputCorreoAdmin.onblur = function () {
        if (inputCorreoAdmin.value == "") {
            var alertDangerCorreoAdmin = document.getElementById("alertDangerCorreoAdmin");
            alertDangerCorreoAdmin.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoAdmin = document.getElementById("alertInfoCorreoAdmin");
        var alertDangerCorreoAdmin = document.getElementById("alertDangerCorreoAdmin");
        if (regex.test(inputCorreoAdmin.value) == false && alertDangerCorreoAdmin.style.display == "none") {
            alertInfoCorreoAdmin.style.display = "block";
        } else {
            alertInfoCorreoAdmin.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveAdmin
var inputClaveAdmin = document.getElementById("claveAdmin");
if (inputClaveAdmin != null) {
    inputClaveAdmin.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveAdmin = document.getElementById("alertDangerClaveAdmin");
        alertDangerClaveAdmin.style.display = "none";

        var alertInfoClaveAdmin = document.getElementById("alertInfoClaveAdmin");
        alertInfoClaveAdmin.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveAdmin.onkeyup = function () {
            var alertInfoClaveAdmin = document.getElementById("alertInfoClaveAdmin");
            if (inputClaveAdmin.value.length >= 8) {
                var checkMinAdmin = document.getElementById("checkMinAdmin");
                checkMinAdmin.style.visibility = "visible";
                checkMinAdmin.style.color = "green";
                //verificado en codigo ascii
                checkMinAdmin.textContent = String.fromCharCode(10004);
            } else {
                var checkMinAdmin = document.getElementById("checkMinAdmin");
                checkMinAdmin.style.visibility = "hidden";
            }
            if (inputClaveAdmin.value.length <= 12) {
                var checkMaxAdmin = document.getElementById("checkMaxAdmin");
                checkMaxAdmin.style.visibility = "visible";
                checkMaxAdmin.style.color = "green";
                //verificado en codigo ascii
                checkMaxAdmin.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxAdmin = document.getElementById("checkMaxAdmin");
                checkMaxAdmin.style.visibility = "hidden";
            }
        };
    };
}
//funciones para mostrar alertas de validación de campos de Administradores en el formulario de administradores activos

//funcion focus y blur para el campo cedulaAdminMod
var inputCedulaAdminMod = document.getElementById("dniAdminMod");
if (inputCedulaAdminMod != null) {
    inputCedulaAdminMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniAdminMod = document.getElementById("alertDangerDniAdminMod");
        alertDangerDniAdminMod.style.display = "none";

        var alertInfoDniAdminMod = document.getElementById(
            "alertInfoDniAdminMod"
        );
        alertInfoDniAdminMod.style.display = "block";
    };
    inputCedulaAdminMod.onblur = function () {
        if (inputCedulaAdminMod.value == "") {
            var alertDangerDniAdminMod = document.getElementById(
                "alertDangerDniAdminMod"
            );
            alertDangerDniAdminMod.style.display = "block";
        }
        var alertInfoDniAdminMod = document.getElementById(
            "alertInfoDniAdminMod"
        );
        alertInfoDniAdminMod.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreAdminMod
var inputNombreAdminMod = document.getElementById("nombreAdminMod");
if (inputNombreAdminMod != null) {
    inputNombreAdminMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreAdminMod = document.getElementById(
            "alertDangerNombreAdminMod"
        );
        alertDangerNombreAdminMod.style.display = "none";
    };
    inputNombreAdminMod.onblur = function () {
        if (inputNombreAdminMod.value == "") {
            var alertDangerNombreAdminMod = document.getElementById(
                "alertDangerNombreAdminMod"
            );
            alertDangerNombreAdminMod.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoAdminMod
var inputApellidoAdminMod = document.getElementById("apellidoAdminMod");
if (inputApellidoAdminMod != null) {
    inputApellidoAdminMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoAdminMod = document.getElementById(
            "alertDangerApellidoAdminMod"
        );
        alertDangerApellidoAdminMod.style.display = "none";
    };
    inputApellidoAdminMod.onblur = function () {
        if (inputApellidoAdminMod.value == "") {
            var alertDangerApellidoAdminMod = document.getElementById(
                "alertDangerApellidoAdminMod"
            );
            alertDangerApellidoAdminMod.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoAdminMod
var inputCorreoAdminMod = document.getElementById("correoAdminMod");
if (inputCorreoAdminMod != null) {
    inputCorreoAdminMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoAdminMod = document.getElementById(
            "alertDangerCorreoAdminMod"
        );
        alertDangerCorreoAdminMod.style.display = "none";

        var alertInfoCorreoAdminMod = document.getElementById(
            "alertInfoCorreoAdminMod"
        );
        alertInfoCorreoAdminMod.style.display = "block";
    };
    inputCorreoAdminMod.onblur = function () {
        if (inputCorreoAdminMod.value == "") {
            var alertDangerCorreoAdminMod = document.getElementById(
                "alertDangerCorreoAdminMod"
            );
            alertDangerCorreoAdminMod.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoAdminMod = document.getElementById(
            "alertInfoCorreoAdminMod"
        );
        var alertDangerCorreoAdminMod = document.getElementById(
            "alertDangerCorreoAdminMod"
        );
        if (regex.test(inputCorreoAdminMod.value) == false && alertDangerCorreoAdminMod.style.display == "none") {
            alertInfoCorreoAdminMod.style.display = "block";
        } else {
            alertInfoCorreoAdminMod.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveAdminMod
var inputClaveAdminMod = document.getElementById("claveAdminMod");
if (inputClaveAdminMod != null) {
    inputClaveAdminMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveAdminMod = document.getElementById(
            "alertDangerClaveAdminMod"
        );
        alertDangerClaveAdminMod.style.display = "none";

        var alertInfoClaveAdminMod = document.getElementById(
            "alertInfoClaveAdminMod"
        );
        alertInfoClaveAdminMod.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveAdminMod.onkeyup = function () {
            var alertInfoClaveAdminMod = document.getElementById(
                "alertInfoClaveAdminMod"
            );
            if (inputClaveAdminMod.value.length >= 8) {
                var checkMinAdminMod = document.getElementById(
                    "checkMinAdminMod"
                );
                checkMinAdminMod.style.visibility = "visible";
                checkMinAdminMod.style.color = "green";
                //verificado en codigo ascii
                checkMinAdminMod.textContent = String.fromCharCode(10004);
            } else {
                var checkMinAdminMod = document.getElementById(
                    "checkMinAdminMod"
                );
                checkMinAdminMod.style.visibility = "hidden";
            }
            if (inputClaveAdminMod.value.length <= 12) {
                var checkMaxAdminMod = document.getElementById(
                    "checkMaxAdminMod"
                );
                checkMaxAdminMod.style.visibility = "visible";
                checkMaxAdminMod.style.color = "green";
                //verificado en codigo ascii
                checkMaxAdminMod.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxAdminMod = document.getElementById(
                    "checkMaxAdminMod"
                );
                checkMaxAdminMod.style.visibility = "hidden";
            }
        };
    };
}

//Funciones para mostrar alertas de validación de campos de Docentes


//funcion focus y blur para el campo cedulaDocente
var inputCedulaDocente = document.getElementById("cedulaDocente");
if (inputCedulaDocente != null) {
    inputCedulaDocente.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniDocente = document.getElementById(
            "alertDangerDniDocente"
        );
        alertDangerDniDocente.style.display = "none";

        var alertInfoDniDocente = document.getElementById("alertInfoDniDocente");
        alertInfoDniDocente.style.display = "block";
    };
    inputCedulaDocente.onblur = function () {
        if (inputCedulaDocente.value == "") {
            var alertDangerDniDocente = document.getElementById(
                "alertDangerDniDocente"
            );
            alertDangerDniDocente.style.display = "block";
        }
        var alertInfoDniDocente = document.getElementById("alertInfoDniDocente");
        alertInfoDniDocente.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreDocente
var inputNombreDocente = document.getElementById("nombreDocente");
if (inputNombreDocente != null) {
    inputNombreDocente.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreDocente = document.getElementById(
            "alertDangerNombreDocente"
        );
        alertDangerNombreDocente.style.display = "none";
    };
    inputNombreDocente.onblur = function () {
        if (inputNombreDocente.value == "") {
            var alertDangerNombreDocente = document.getElementById(
                "alertDangerNombreDocente"
            );
            alertDangerNombreDocente.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoDocente
var inputApellidoDocente = document.getElementById("apellidoDocente");
if (inputApellidoDocente != null) {
    inputApellidoDocente.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoDocente = document.getElementById(
            "alertDangerApellidoDocente"
        );
        alertDangerApellidoDocente.style.display = "none";
    };
    inputApellidoDocente.onblur = function () {
        if (inputApellidoDocente.value == "") {
            var alertDangerApellidoDocente = document.getElementById(
                "alertDangerApellidoDocente"
            );
            alertDangerApellidoDocente.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoDocente
var inputCorreoDocente = document.getElementById("correoDocente");
if (inputCorreoDocente != null) {
    inputCorreoDocente.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoDocente = document.getElementById(
            "alertDangerCorreoDocente"
        );
        alertDangerCorreoDocente.style.display = "none";

        var alertInfoCorreoDocente = document.getElementById(
            "alertInfoCorreoDocente"
        );
        alertInfoCorreoDocente.style.display = "block";
    };
    inputCorreoDocente.onblur = function () {
        if (inputCorreoDocente.value == "") {
            var alertDangerCorreoDocente = document.getElementById(
                "alertDangerCorreoDocente"
            );
            alertDangerCorreoDocente.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoDocente = document.getElementById(
            "alertInfoCorreoDocente"
        );
        var alertDangerCorreoDocente = document.getElementById(
            "alertDangerCorreoDocente"
        );
        if (regex.test(inputCorreoDocente.value) == false && alertDangerCorreoDocente.style.display == "none") {
            alertInfoCorreoDocente.style.display = "block";
        } else {
            alertInfoCorreoDocente.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveDocente
var inputClaveDocente = document.getElementById("claveDocente");
if (inputClaveDocente != null) {
    inputClaveDocente.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveDocente = document.getElementById(
            "alertDangerClaveDocente"
        );
        alertDangerClaveDocente.style.display = "none";

        var alertInfoClaveDocente = document.getElementById(
            "alertInfoClaveDocente"
        );
        alertInfoClaveDocente.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveDocente.onkeyup = function () {
            var alertInfoClaveDocente = document.getElementById(
                "alertInfoClaveDocente"
            );
            if (inputClaveDocente.value.length >= 8) {
                var checkMinDocente = document.getElementById("checkMinDocente");
                checkMinDocente.style.visibility = "visible";
                checkMinDocente.style.color = "green";
                //verificado en codigo ascii
                checkMinDocente.textContent = String.fromCharCode(10004);
            } else {
                var checkMinDocente = document.getElementById("checkMinDocente");
                checkMinDocente.style.visibility = "hidden";
            }
            if (inputClaveDocente.value.length <= 12) {
                var checkMaxDocente = document.getElementById("checkMaxDocente");
                checkMaxDocente.style.visibility = "visible";
                checkMaxDocente.style.color = "green";
                //verificado en codigo ascii
                checkMaxDocente.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxDocente = document.getElementById("checkMaxDocente");
                checkMaxDocente.style.visibility = "hidden";
            }
        };
    };
}

//Funciones para mostrar alertas de validación de campos de Docentes en el formulario de docentes activos

//funcion focus y blur para el campo cedulaDocenteMod
var inputCedulaDocenteMod = document.getElementById("dniDocenteMod");
if (inputCedulaDocenteMod != null) {
    inputCedulaDocenteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniDocenteMod = document.getElementById(
            "alertDangerDniDocenteMod"
        );
        alertDangerDniDocenteMod.style.display = "none";

        var alertInfoDniDocenteMod = document.getElementById(
            "alertInfoDniDocenteMod"
        );
        alertInfoDniDocenteMod.style.display = "block";
    };
    inputCedulaDocenteMod.onblur = function () {
        if (inputCedulaDocenteMod.value == "") {
            var alertDangerDniDocenteMod = document.getElementById(
                "alertDangerDniDocenteMod"
            );
            alertDangerDniDocenteMod.style.display = "block";
        }
        var alertInfoDniDocenteMod = document.getElementById(
            "alertInfoDniDocenteMod"
        );
        alertInfoDniDocenteMod.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreDocenteMod
var inputNombreDocenteMod = document.getElementById("nombreDocenteMod");
if (inputNombreDocenteMod != null) {
    inputNombreDocenteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreDocenteMod = document.getElementById(
            "alertDangerNombreDocenteMod"
        );
        alertDangerNombreDocenteMod.style.display = "none";
    };
    inputNombreDocenteMod.onblur = function () {
        if (inputNombreDocenteMod.value == "") {
            var alertDangerNombreDocenteMod = document.getElementById(
                "alertDangerNombreDocenteMod"
            );
            alertDangerNombreDocenteMod.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoDocenteMod
var inputApellidoDocenteMod = document.getElementById("apellidoDocenteMod");
if (inputApellidoDocenteMod != null) {
    inputApellidoDocenteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoDocenteMod = document.getElementById(
            "alertDangerApellidoDocenteMod"
        );
        alertDangerApellidoDocenteMod.style.display = "none";
    };
    inputApellidoDocenteMod.onblur = function () {
        if (inputApellidoDocenteMod.value == "") {
            var alertDangerApellidoDocenteMod = document.getElementById(
                "alertDangerApellidoDocenteMod"
            );
            alertDangerApellidoDocenteMod.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoDocenteMod
var inputCorreoDocenteMod = document.getElementById("correoDocenteMod");
if (inputCorreoDocenteMod != null) {
    inputCorreoDocenteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoDocenteMod = document.getElementById(
            "alertDangerCorreoDocenteMod"
        );
        alertDangerCorreoDocenteMod.style.display = "none";

        var alertInfoCorreoDocenteMod = document.getElementById(
            "alertInfoCorreoDocenteMod"
        );
        alertInfoCorreoDocenteMod.style.display = "block";
    };
    inputCorreoDocenteMod.onblur = function () {
        if (inputCorreoDocenteMod.value == "") {
            var alertDangerCorreoDocenteMod = document.getElementById(
                "alertDangerCorreoDocenteMod"
            );
            alertDangerCorreoDocenteMod.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoDocenteMod = document.getElementById(
            "alertInfoCorreoDocenteMod"
        );
        var alertDangerCorreoDocenteMod = document.getElementById(
            "alertDangerCorreoDocenteMod"
        );
        if (regex.test(inputCorreoDocenteMod.value) == false && alertDangerCorreoDocenteMod.style.display == "none") {
            alertInfoCorreoDocenteMod.style.display = "block";
        } else {
            alertInfoCorreoDocenteMod.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveDocenteMod
var inputClaveDocenteMod = document.getElementById("claveDocenteMod");
if (inputClaveDocenteMod != null) {
    inputClaveDocenteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveDocenteMod = document.getElementById(
            "alertDangerClaveDocenteMod"
        );
        alertDangerClaveDocenteMod.style.display = "none";

        var alertInfoClaveDocenteMod = document.getElementById(
            "alertInfoClaveDocenteMod"
        );
        alertInfoClaveDocenteMod.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveDocenteMod.onkeyup = function () {
            var alertInfoClaveDocenteMod = document.getElementById(
                "alertInfoClaveDocenteMod"
            );
            if (inputClaveDocenteMod.value.length >= 8) {
                var checkMinDocenteMod = document.getElementById(
                    "checkMinDocenteMod"
                );
                checkMinDocenteMod.style.visibility = "visible";
                checkMinDocenteMod.style.color = "green";
                //verificado en codigo ascii
                checkMinDocenteMod.textContent = String.fromCharCode(10004);
            } else {
                var checkMinDocenteMod = document.getElementById(
                    "checkMinDocenteMod"
                );
                checkMinDocenteMod.style.visibility = "hidden";
            }
            if (inputClaveDocenteMod.value.length <= 12) {
                var checkMaxDocenteMod = document.getElementById(
                    "checkMaxDocenteMod"
                );
                checkMaxDocenteMod.style.visibility = "visible";
                checkMaxDocenteMod.style.color = "green";
                //verificado en codigo ascii
                checkMaxDocenteMod.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxDocenteMod = document.getElementById(
                    "checkMaxDocenteMod"
                );
                checkMaxDocenteMod.style.visibility = "hidden";
            }
        };
    };
}

//Funciones para mostrar alertas de validación de campos de Estudiantes

//funcion focus y blur para el campo cedulaEstudiante
var inputCedulaEstudiante = document.getElementById("cedulaEstudiante");
if (inputCedulaEstudiante != null) {
    inputCedulaEstudiante.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniEstudiante = document.getElementById(
            "alertDangerDniEstudiante"
        );
        alertDangerDniEstudiante.style.display = "none";

        var alertInfoDniEstudiante = document.getElementById(
            "alertInfoDniEstudiante"
        );
        alertInfoDniEstudiante.style.display = "block";
    };
    inputCedulaEstudiante.onblur = function () {
        if (inputCedulaEstudiante.value == "") {
            var alertDangerDniEstudiante = document.getElementById(
                "alertDangerDniEstudiante"
            );
            alertDangerDniEstudiante.style.display = "block";
        }
        var alertInfoDniEstudiante = document.getElementById(
            "alertInfoDniEstudiante"
        );
        alertInfoDniEstudiante.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreEstudiante
var inputNombreEstudiante = document.getElementById("nombreEstudiante");
if (inputNombreEstudiante != null) {
    inputNombreEstudiante.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreEstudiante = document.getElementById(
            "alertDangerNombreEstudiante"
        );
        alertDangerNombreEstudiante.style.display = "none";
    };
    inputNombreEstudiante.onblur = function () {
        if (inputNombreEstudiante.value == "") {
            var alertDangerNombreEstudiante = document.getElementById(
                "alertDangerNombreEstudiante"
            );
            alertDangerNombreEstudiante.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoEstudiante
var inputApellidoEstudiante = document.getElementById("apellidoEstudiante");
if (inputApellidoEstudiante != null) {
    inputApellidoEstudiante.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoEstudiante = document.getElementById(
            "alertDangerApellidoEstudiante"
        );
        alertDangerApellidoEstudiante.style.display = "none";
    };
    inputApellidoEstudiante.onblur = function () {
        if (inputApellidoEstudiante.value == "") {
            var alertDangerApellidoEstudiante = document.getElementById(
                "alertDangerApellidoEstudiante"
            );
            alertDangerApellidoEstudiante.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoEstudiante
var inputCorreoEstudiante = document.getElementById("correoEstudiante");
if (inputCorreoEstudiante != null) {
    inputCorreoEstudiante.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoEstudiante = document.getElementById(
            "alertDangerCorreoEstudiante"
        );
        alertDangerCorreoEstudiante.style.display = "none";

        var alertInfoCorreoEstudiante = document.getElementById(
            "alertInfoCorreoEstudiante"
        );
        alertInfoCorreoEstudiante.style.display = "block";
    };
    inputCorreoEstudiante.onblur = function () {
        if (inputCorreoEstudiante.value == "") {
            var alertDangerCorreoEstudiante = document.getElementById(
                "alertDangerCorreoEstudiante"
            );
            alertDangerCorreoEstudiante.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoEstudiante = document.getElementById(
            "alertInfoCorreoEstudiante"
        );
        var alertDangerCorreoEstudiante = document.getElementById(
            "alertDangerCorreoEstudiante"
        );
        if (regex.test(inputCorreoEstudiante.value) == false && alertDangerCorreoEstudiante.style.display == "none") {
            alertInfoCorreoEstudiante.style.display = "block";
        } else {
            alertInfoCorreoEstudiante.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveEstudiante
var inputClaveEstudiante = document.getElementById("claveEstudiante");
if (inputClaveEstudiante != null) {
    inputClaveEstudiante.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveEstudiante = document.getElementById(
            "alertDangerClaveEstudiante"
        );
        alertDangerClaveEstudiante.style.display = "none";

        var alertInfoClaveEstudiante = document.getElementById(
            "alertInfoClaveEstudiante"
        );
        alertInfoClaveEstudiante.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveEstudiante.onkeyup = function () {
            var alertInfoClaveEstudiante = document.getElementById(
                "alertInfoClaveEstudiante"
            );
            if (inputClaveEstudiante.value.length >= 8) {
                var checkMinEstudiante = document.getElementById(
                    "checkMinEstudiante"
                );
                checkMinEstudiante.style.visibility = "visible";
                checkMinEstudiante.style.color = "green";
                //verificado en codigo ascii
                checkMinEstudiante.textContent = String.fromCharCode(10004);
            } else {
                var checkMinEstudiante = document.getElementById(
                    "checkMinEstudiante"
                );
                checkMinEstudiante.style.visibility = "hidden";
            }
            if (inputClaveEstudiante.value.length <= 12) {
                var checkMaxEstudiante = document.getElementById(
                    "checkMaxEstudiante"
                );
                checkMaxEstudiante.style.visibility = "visible";
                checkMaxEstudiante.style.color = "green";
                //verificado en codigo ascii
                checkMaxEstudiante.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxEstudiante = document.getElementById(
                    "checkMaxEstudiante"
                );
                checkMaxEstudiante.style.visibility = "hidden";
            }
        };
    };
}

//Funciones para mostrar alertas de validación de campos de Estudiantes en el formulario de estudiantes activos

//funcion focus y blur para el campo cedulaEstudianteMod
var inputCedulaEstudianteMod = document.getElementById("dniEstudianteMod");
if (inputCedulaEstudianteMod != null) {
    inputCedulaEstudianteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniEstudianteMod = document.getElementById(
            "alertDangerDniEstudianteMod"
        );
        alertDangerDniEstudianteMod.style.display = "none";

        var alertInfoDniEstudianteMod = document.getElementById(
            "alertInfoDniEstudianteMod"
        );
        alertInfoDniEstudianteMod.style.display = "block";
    };
    inputCedulaEstudianteMod.onblur = function () {
        if (inputCedulaEstudianteMod.value == "") {
            var alertDangerDniEstudianteMod = document.getElementById(
                "alertDangerDniEstudianteMod"
            );
            alertDangerDniEstudianteMod.style.display = "block";
        }
        var alertInfoDniEstudianteMod = document.getElementById(
            "alertInfoDniEstudianteMod"
        );
        alertInfoDniEstudianteMod.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreEstudianteMod
var inputNombreEstudianteMod = document.getElementById("nombreEstudianteMod");
if (inputNombreEstudianteMod != null) {
    inputNombreEstudianteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreEstudianteMod = document.getElementById(
            "alertDangerNombreEstudianteMod"
        );
        alertDangerNombreEstudianteMod.style.display = "none";
    };
    inputNombreEstudianteMod.onblur = function () {
        if (inputNombreEstudianteMod.value == "") {
            var alertDangerNombreEstudianteMod = document.getElementById(
                "alertDangerNombreEstudianteMod"
            );
            alertDangerNombreEstudianteMod.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoEstudianteMod
var inputApellidoEstudianteMod = document.getElementById(
    "apellidoEstudianteMod"
);
if (inputApellidoEstudianteMod != null) {
    inputApellidoEstudianteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoEstudianteMod = document.getElementById(
            "alertDangerApellidoEstudianteMod"
        );
        alertDangerApellidoEstudianteMod.style.display = "none";
    };
    inputApellidoEstudianteMod.onblur = function () {
        if (inputApellidoEstudianteMod.value == "") {
            var alertDangerApellidoEstudianteMod = document.getElementById(
                "alertDangerApellidoEstudianteMod"
            );
            alertDangerApellidoEstudianteMod.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoEstudianteMod
var inputCorreoEstudianteMod = document.getElementById("correoEstudianteMod");
if (inputCorreoEstudianteMod != null) {
    inputCorreoEstudianteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoEstudianteMod = document.getElementById(
            "alertDangerCorreoEstudianteMod"
        );
        alertDangerCorreoEstudianteMod.style.display = "none";

        var alertInfoCorreoEstudianteMod = document.getElementById(
            "alertInfoCorreoEstudianteMod"
        );
        alertInfoCorreoEstudianteMod.style.display = "block";
    };
    inputCorreoEstudianteMod.onblur = function () {
        if (inputCorreoEstudianteMod.value == "") {
            var alertDangerCorreoEstudianteMod = document.getElementById(
                "alertDangerCorreoEstudianteMod"
            );
            alertDangerCorreoEstudianteMod.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoEstudianteMod = document.getElementById(
            "alertInfoCorreoEstudianteMod"
        );
        var alertDangerCorreoEstudianteMod = document.getElementById(
            "alertDangerCorreoEstudianteMod"
        );
        if (regex.test(inputCorreoEstudianteMod.value) == false && alertDangerCorreoEstudianteMod.style.display == "none") {
            alertInfoCorreoEstudianteMod.style.display = "block";
        } else {
            alertInfoCorreoEstudianteMod.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveEstudianteMod
var inputClaveEstudianteMod = document.getElementById("claveEstudianteMod");
if (inputClaveEstudianteMod != null) {
    inputClaveEstudianteMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveEstudianteMod = document.getElementById(
            "alertDangerClaveEstudianteMod"
        );
        alertDangerClaveEstudianteMod.style.display = "none";

        var alertInfoClaveEstudianteMod = document.getElementById(
            "alertInfoClaveEstudianteMod"
        );
        alertInfoClaveEstudianteMod.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveEstudianteMod.onkeyup = function () {
            var alertInfoClaveEstudianteMod = document.getElementById(
                "alertInfoClaveEstudianteMod"
            );
            if (inputClaveEstudianteMod.value.length >= 8) {
                var checkMinEstudianteMod = document.getElementById(
                    "checkMinEstudianteMod"
                );
                checkMinEstudianteMod.style.visibility = "visible";
                checkMinEstudianteMod.style.color = "green";
                //verificado en codigo ascii
                checkMinEstudianteMod.textContent = String.fromCharCode(10004);
            } else {
                var checkMinEstudianteMod = document.getElementById(
                    "checkMinEstudianteMod"
                );
                checkMinEstudianteMod.style.visibility = "hidden";
            }
            if (inputClaveEstudianteMod.value.length <= 12) {
                var checkMaxEstudianteMod = document.getElementById(
                    "checkMaxEstudianteMod"
                );
                checkMaxEstudianteMod.style.visibility = "visible";
                checkMaxEstudianteMod.style.color = "green";
                //verificado en codigo ascii
                checkMaxEstudianteMod.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxEstudianteMod = document.getElementById(
                    "checkMaxEstudianteMod"
                );
                checkMaxEstudianteMod.style.visibility = "hidden";
            }
        };
    };
}

//Funciones para mostrar alertas de validación de campos de Docentes active

//funcion focus y blur para el campo cedulaDocenteActive
var inputCedulaDocenteActive = document.getElementById("cedulaDocenteActive");
if (inputCedulaDocenteActive != null) {
    inputCedulaDocenteActive.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniDocenteActive = document.getElementById(
            "alertDangerDniDocenteActive"
        );
        alertDangerDniDocenteActive.style.display = "none";

        var alertInfoDniDocenteActive = document.getElementById(
            "alertInfoDniDocenteActive"
        );
        alertInfoDniDocenteActive.style.display = "block";
    };
    inputCedulaDocenteActive.onblur = function () {
        if (inputCedulaDocenteActive.value == "") {
            var alertDangerDniDocenteActive = document.getElementById(
                "alertDangerDniDocenteActive"
            );
            alertDangerDniDocenteActive.style.display = "block";
        }
        var alertInfoDniDocenteActive = document.getElementById(
            "alertInfoDniDocenteActive"
        );
        alertInfoDniDocenteActive.style.display = "none";
    };
}

//funcion focus y blur para el campo nombreDocenteActive
var inputNombreDocenteActive = document.getElementById("nombreDocenteActive");
if (inputNombreDocenteActive != null) {
    inputNombreDocenteActive.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerNombreDocenteActive = document.getElementById(
            "alertDangerNombreDocenteActive"
        );
        alertDangerNombreDocenteActive.style.display = "none";
    };
    inputNombreDocenteActive.onblur = function () {
        if (inputNombreDocenteActive.value == "") {
            var alertDangerNombreDocenteActive = document.getElementById(
                "alertDangerNombreDocenteActive"
            );
            alertDangerNombreDocenteActive.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo apellidoDocenteActive
var inputApellidoDocenteActive = document.getElementById(
    "apellidoDocenteActive"
);
if (inputApellidoDocenteActive != null) {
    inputApellidoDocenteActive.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerApellidoDocenteActive = document.getElementById(
            "alertDangerApellidoDocenteActive"
        );
        alertDangerApellidoDocenteActive.style.display = "none";
    };
    inputApellidoDocenteActive.onblur = function () {
        if (inputApellidoDocenteActive.value == "") {
            var alertDangerApellidoDocenteActive = document.getElementById(
                "alertDangerApellidoDocenteActive"
            );
            alertDangerApellidoDocenteActive.style.display = "block";
        }
    };
}

//funcion focus y blur para el campo correoDocenteActive
var inputCorreoDocenteActive = document.getElementById("correoDocenteActive");
if (inputCorreoDocenteActive != null) {
    inputCorreoDocenteActive.onfocus = function () {

        // desactivamos la alerta mientras hay focus en el input
        var alertDangerCorreoDocenteActive = document.getElementById(
            "alertDangerCorreoDocenteActive"
        );
        alertDangerCorreoDocenteActive.style.display = "none";

        var alertInfoCorreoDocenteActive = document.getElementById(
            "alertInfoCorreoDocenteActive"
        );
        alertInfoCorreoDocenteActive.style.display = "block";
    };
    inputCorreoDocenteActive.onblur = function () {
        if (inputCorreoDocenteActive.value == "") {
            var alertDangerCorreoDocenteActive = document.getElementById(
                "alertDangerCorreoDocenteActive"
            );
            alertDangerCorreoDocenteActive.style.display = "block";
        }
        var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$/;
        var alertInfoCorreoDocenteActive = document.getElementById(
            "alertInfoCorreoDocenteActive"
        );
        var alertDangerCorreoDocenteActive = document.getElementById(
            "alertDangerCorreoDocenteActive"
        );
        if (regex.test(inputCorreoDocenteActive.value) == false && alertDangerCorreoDocenteActive.style.display == "none") {
            alertInfoCorreoDocenteActive.style.display = "block";
        } else {
            alertInfoCorreoDocenteActive.style.display = "none";
        }
    };
}

//funcion focus y blur para el campo claveDocenteActive
var inputClaveDocenteActive = document.getElementById("claveDocenteActive");
if (inputClaveDocenteActive != null) {
    inputClaveDocenteActive.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerClaveDocenteActive = document.getElementById(
            "alertDangerClaveDocenteActive"
        );
        alertDangerClaveDocenteActive.style.display = "none";

        var alertInfoClaveDocenteActive = document.getElementById(
            "alertInfoClaveDocenteActive"
        );
        alertInfoClaveDocenteActive.style.display = "block";

        // colocar un chulo si la clave es mayor a 8 caracteres
        inputClaveDocenteActive.onkeyup = function () {
            var alertInfoClaveDocenteActive = document.getElementById(
                "alertInfoClaveDocenteActive"
            );
            if (inputClaveDocenteActive.value.length >= 8) {
                var checkMinDocenteActive = document.getElementById(
                    "checkMinDocenteActive"
                );
                checkMinDocenteActive.style.visibility = "visible";
                checkMinDocenteActive.style.color = "green";
                //verificado en codigo ascii
                checkMinDocenteActive.textContent = String.fromCharCode(10004);
            } else {
                var checkMinDocenteActive = document.getElementById(
                    "checkMinDocenteActive"
                );
                checkMinDocenteActive.style.visibility = "hidden";
            }
            if (inputClaveDocenteActive.value.length <= 12) {
                var checkMaxDocenteActive = document.getElementById(
                    "checkMaxDocenteActive"
                );
                checkMaxDocenteActive.style.visibility = "visible";
                checkMaxDocenteActive.style.color = "green";
                //verificado en codigo ascii
                checkMaxDocenteActive.textContent = String.fromCharCode(10004);
            } else {
                var checkMaxDocenteActive = document.getElementById(
                    "checkMaxDocenteActive"
                );
                checkMaxDocenteActive.style.visibility = "hidden";
            }
        };
    };
}

//Funciones para mostrar alertas de validación de campos de Doceentes en el formulario de docentes activos

//funcion focus y blur para el campo cedulaDocenteActiveMod
var inputCedulaDocenteActiveMod = document.getElementById(
    "dniDocenteActiveMod"
);
if (inputCedulaDocenteActiveMod != null) {
    inputCedulaDocenteActiveMod.onfocus = function () {
        // desactivamos la alerta mientras hay focus en el input
        var alertDangerDniDocenteActiveMod = document.getElementById(
            "alertDangerDniDocenteActiveMod"
        );
        alertDangerDniDocenteActiveMod.style.display = "none";

        var alertInfoDniDocenteActiveMod = document.getElementById(
            "alertInfoDniDocenteActiveMod"
        );
        alertInfoDniDocenteActiveMod.style.display = "block";
    };
    inputCedulaDocenteActiveMod.onblur = function () {
        if (inputCedulaDocenteActiveMod.value == "") {
            var alertDangerDniDocenteActiveMod = document.getElementById(
                "alertDangerDniDocenteActiveMod"
            );
            alertDangerDniDocenteActiveMod.style.display = "block";
        }
        var alertInfoDniDocenteActiveMod = document.getElementById(
            "alertInfoDniDocenteActiveMod"
        );
        alertInfoDniDocenteActiveMod.style.display = "none";
    };
}


//Funcion para mostrar y ocultar contraseña

function password_show_hide() {
    var x = document.getElementById("claveAdmin");
    var show_eye = document.getElementById("show_eye");
    var hide_eye = document.getElementById("hide_eye");
    hide_eye.classList.remove("d-none");
    if (x.type === "password") {
        x.type = "text";
        show_eye.style.display = "none";
        hide_eye.style.display = "block";
    } else {
        x.type = "password";
        show_eye.style.display = "block";
        hide_eye.style.display = "none";
    }
}

//Funcion para quitar las alertas de validación de campos
function resetAlerts() {
    var alertDangerDniAdmin = document.getElementById("alertDangerDniAdmin");
    alertDangerDniAdmin.style.display = "none";

    var alertDangerNombre = document.getElementById("alertDangerNombreAdmin");
    alertDangerNombre.style.display = "none";

    var alertDangerApellido = document.getElementById(
        "alertDangerApellidoAdmin"
    );
    alertDangerApellido.style.display = "none";

    var alertDangerCorreo = document.getElementById("alertDangerCorreoAdmin");
    alertDangerCorreo.style.display = "none";

    var alertDangerClave = document.getElementById("alertDangerClaveAdmin");
    alertDangerClave.style.display = "none";

    return true;

}