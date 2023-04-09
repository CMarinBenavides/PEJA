const signUpButton = document.getElementById('signUp');//seleccionando un botón del DOM, asignándolo a una constante y añadiendo un evento "click" al botón para manipular un contenedor en la página; es para registrarse.
const signInButton = document.getElementById('signIn');//seleccionando un botón del DOM, asignándolo a una constante y añadiendo un evento "click" al botón para manipular un contenedor en la página; es para iniciar sesión.
const container = document.getElementById('container');// está seleccionando un contenedor del DOM, asignándolo a una constante y añadiendo eventos "click" a dos botones para manipular el contenedor en la página.

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
}); //está añadiendo un evento "click" al botón de registro que llama a una función para manipular el contenedor HTML agregando una clase CSS "right-panel-active". En sí añade.

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
}); //está añadiendo un evento "click" al botón de registro que llama a una función para manipular el contenedor HTML agregando una clase CSS "right-panel-active". En sí Elimina o remueve.

function mostrar() {
    var tipo = document.getElementById("password");

    if (tipo.type == "password") {
        tipo.type = "text";
    } else {
        tipo.type = "password";
    }
} // Esta función se utiliza para permitir que los usuarios muestren u oculten la contraseña que están ingresando en un formulario, ya que a veces los usuarios pueden querer verificar que han ingresado la contraseña correctamente antes de enviar el formulario.

function validate(event) {
    var email = document.getElementById("username").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/; //  la expresión regular verifica que el correo electrónico tenga un formato válido (nombre de usuario seguido de un símbolo "@" seguido de un dominio válido).
    if (re.test(email)) {
        return true;
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingrese un correo valido',
            toast: true,
            position: 'top-start',
            showConfirmButton: false,
            timer: 1000,
        });
        event.preventDefault();
        return false;
    }// se valida si esta bien el correo que se suministrado o si no se envia un mensaje de error.
}//la función "validate()" se utiliza para verificar que el campo de correo electrónico en un formulario tenga un valor válido antes de enviar el formulario.