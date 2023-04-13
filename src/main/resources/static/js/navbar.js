const nav = document.querySelector('.nav') // se guarda en una variable constante nav con un atributo obtenido del HTML. Esto depende del atributo que tenga el identificar .nav
const hero = document.querySelector('.hero') // se guarda en una variable constante img con un atributo obtenido del HTML. Esto depende del atributo que tenga el identificar .hero
window.addEventListener('scroll', fixNav) //está permitiendo agregar un efecto de "scroll" fijo a un elemento de navegación en una página web.


function fixNav() {
    if (window.scrollY > hero.clientHeight - nav.clientHeight) { // si el scroll es mayor a la altura de la imagen hero, se ejecuta la función.
        nav.classList.add('active')// hace cambos en la funcón que manja el css. En este caso add.
    } else {
        nav.classList.remove('active')// hace cambos en la funcón que manja el css. En este caso Remove.
    }
} // la función "fixNav" cambia dinámicamente el estilo de un elemento de navegación en respuesta al desplazamiento vertical del usuario en la página, lo que le permite mantenerse visible y fijo en una posición específica de la página.
