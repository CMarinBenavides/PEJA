package com.archerprop.peja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.service.UsuarioService;
import com.archerprop.peja.entity.Usuario;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Retorna un nuevo objeto UsuarioRegistroDTO para ser utilizado en el formulario de registro.
     *
     * @return Un objeto UsuarioRegistroDTO vacío.
     */
    @ModelAttribute("usuarioregistro")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Muestra el formulario de registro de usuarios.
     *
     * @return La vista "registro".
     */
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    /**
     * Registra un usuario con el rol "ADMIN".
     *
     * @param RegistroDTO Un objeto UsuarioRegistroDTO que contiene la información del usuario a registrar.
     * @return Redirige a la página "admin" con un mensaje de éxito o fracaso.
     */
    @PostMapping("/admin")
    public String registrarUsuarioA(@ModelAttribute("usuarioresgistro") UsuarioRegistroDTO RegistroDTO) {
        try {
            if (usuarioService.guardar(RegistroDTO, "ADMIN") != null) {
                return "redirect:/admin?success";
            }
        } catch (Exception e) {
            return "redirect:/admin?failure";
        }
        return "redirect:/admin?failure";
    }

    /**
     * Modifica un usuario con el rol "ADMIN".
     *
     * @param RegistroDTO Un objeto UsuarioRegistroDTO que contiene la información del usuario a modificar.
     * @param model       El modelo que se utilizará para agregar atributos a la vista.
     * @return Redirige a la página "admin" con un mensaje de éxito o fracaso.
     */
    @PostMapping("/admin/mod")
    public String modificarUsuarioA(@ModelAttribute("usuarioresgistro") UsuarioRegistroDTO RegistroDTO, Model model) {
        try {
            if (usuarioService.modificar(RegistroDTO, "ADMIN")) {
                Usuario usuario = null;
                model.addAttribute("usuarioregistro", usuario);
                model.addAttribute("modificar", false);
                return "redirect:/admin?successChange";
            }
        } catch (Exception e) {
            return "redirect:/admin?failure";
        }
        return "redirect:/admin?failure";
    }

    /**
     * Registra un usuario con el rol "DOCENTE".
     *
     * @param RegistroDTO Un objeto UsuarioRegistroDTO que contiene la información del usuario a registrar.
     * @return Redirige a la página "docente" con un mensaje de éxito o fracaso.
     */
    @PostMapping("/docente")
    public String registrarUsuarioD(@ModelAttribute("usuarioresgistro") UsuarioRegistroDTO RegistroDTO) {
        try {
            if (usuarioService.guardar(RegistroDTO, "DOCENTE") != null) {
                return "redirect:/docente?success";
            }
        } catch (Exception e) {
            return "redirect:/docente?failure";
        }
        return "redirect:/docente?failure";
    }

    /**
     * Registra un usuario con el rol "ESTUDIANTE".
     *
     * @param RegistroDTO Un objeto UsuarioRegistroDTO que contiene la información del usuario a registrar.
     * @return Redirige a la página "estudiante" con un mensaje de éxito o fracaso.
     */
    @PostMapping("/estudiante")
public String registrarUsuarioE(@ModelAttribute("usuarioresgistro") UsuarioRegistroDTO RegistroDTO) {
        try {
            if (usuarioService.guardar(RegistroDTO, "ESTUDIANTE") != null) {
                return "redirect:/estudiante?success";
            }
        } catch (Exception e) {
            return "redirect:/estudiante?failure";
        }
        return "redirect:/estudiante?failure";
    }

}
