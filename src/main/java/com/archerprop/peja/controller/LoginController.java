package com.archerprop.peja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.security.core.Authentication;

import com.archerprop.peja.dto.UsuarioRegistroDTO;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(Authentication authentication) {

        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("SUPERADMIN"))) {
            return "redirect:/admin";
        }
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("USER"))) {
            return "redirect:/user";
        }
        return "redirect:/login";

    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

}
