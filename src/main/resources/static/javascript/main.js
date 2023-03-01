$.getScript("jquery-3.6.0.min.js");

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

function mostrar() {
    var tipo = document.getElementById("password");

    if (tipo.type == "password") {
        tipo.type = "text";
    } else {
        tipo.type = "password";
    }
}

function validate(event) {
    var email = document.getElementById("username").value;
    // verificamos si el email es gmail
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
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
    }
}