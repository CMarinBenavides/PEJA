package com.archerprop.peja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.security.core.Authentication;

import com.archerprop.peja.dto.UsuarioRegistroDTO;

@Controller
public class LoginController {

    /**
     * Controlador para la página de inicio de sesión. holaaaa
     *
     * @return la vista "login"
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Controlador para la página de inicio. Si el usuario es un superadministrador
     * o un administrador, lo redirecciona a la página de administrador, si es un
     * usuario regular, lo redirecciona a la página de usuario.
     *
     * @param authentication objeto de autenticación de Spring Security
     * @return la vista correspondiente según el tipo de usuario
     */
    @GetMapping("/index")
    public String index(Authentication authentication) {

        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("SUPERADMIN"))
                || authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {
            return "redirect:/admin";
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("USER"))) {
            return "redirect:/user";
        }
        return "redirect:/login";
    }

    /**
     * Crea un objeto UsuarioRegistroDTO vacío y lo agrega al modelo.
     *
     * @return un objeto UsuarioRegistroDTO vacío
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

}
