package com.archerprop.peja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.entity.Usuario;
import com.archerprop.peja.dto.UsuarioRegistroDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.security.Principal;
import java.util.List;

import org.springframework.ui.Model;
import com.archerprop.peja.service.Impl.UsuarioServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public String admin(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login";
        }
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        // List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuario", usuario);

        return "admin";
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }
}
