
const header = document.getElementById('header')// trae del HTML un atributo con la etiqueta de header y lo guarda en unacostante.
const title = document.getElementById('title')// trae del HTML un atributo con la etiqueta de title y lo guarda en unacostante.
const excerpt = document.getElementById('excerpt')// trae del HTML un atributo con la etiqueta de excerpt y lo guarda en unacostante.
const profile_img = document.getElementById('profile_img')// trae del HTML un atributo con la etiqueta de profile_img y lo guarda en unacostante.
const name = document.getElementById('name')// trae del HTML un atributo con la etiqueta de name y lo guarda en unacostante.
const date = document.getElementById('date')// trae del HTML un atributo con la etiqueta de date y lo guarda en unacostante.

const animated_bgs = document.querySelectorAll('.animated-bg') // La línea de código const animated_bgs = document.querySelectorAll('.animated-bg') está buscando y guardando todos los elementos en la página web que tienen una clase CSS llamada "animated-bg". Estos elementos se guardan en una lista llamada animated_bgs, que se puede usar para hacer cosas con esos elementos.
const animated_bg_texts = document.querySelectorAll('.animated-bg-text') //Es similar a la línea de código anterior, pero busca elementos con una clase CSS diferente llamada "animated-bg-text".

setTimeout(getData, 2500) // le envia a este metodo los atributos de get Date y 2500.

function getData() {
    header.innerHTML =
        '<img src="https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2102&q=80" alt="" />'
    title.innerHTML = 'Lorem ipsum dolor sit amet'
    excerpt.innerHTML =
        'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore perferendis'
    profile_img.innerHTML =
        '<img src="https://randomuser.me/api/portraits/men/45.jpg" alt="" />'
    name.innerHTML = 'John Doe'
    date.innerHTML = 'Oct 08, 2020'

    animated_bgs.forEach((bg) => bg.classList.remove('animated-bg'))
    animated_bg_texts.forEach((bg) => bg.classList.remove('animated-bg-text'))
}//La función getData() rellena diferentes partes de una página web con información ficticia. Agrega una imagen, título, un extracto, imagen de perfil, nombre y fecha. También quita las clases animated-bg y animated-bg-text de los elementos que las tienen.