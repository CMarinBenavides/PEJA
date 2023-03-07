package com.archerprop.peja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.entity.Usuario;
import com.archerprop.peja.dto.UsuarioRegistroDTO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
        List<Usuario> usuarios = usuarioService.listarUsuariosAdmin();
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuariosAdmin", usuarios);

        return "admin";
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioDTO() {
        return new UsuarioRegistroDTO();
    }

    @ModelAttribute("usuarioregistro")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping("/{correo}")
    public String modificarUsuario(@PathVariable String correo, Model model) {
        Usuario usuario = usuarioService.buscarUsuario(correo);
        model.addAttribute("usuarioregistro", usuario);
        return "admin";
    }

    @GetMapping("/{correo}/delete")
    public String eliminarUsuario(@PathVariable String correo, Model model) {
        Usuario usuarioR = usuarioService.buscarUsuario(correo);
        try {
            if (usuarioService.eliminar(usuarioR)) {
                Usuario usuario = null;
                model.addAttribute("usuarioregistro", usuario);
                return "redirect:/admin?successDelete";
            }
        } catch (Exception e) {
            return "redirect:/admin?failure";
        }
        return "redirect:/admin?failure";
    }

}
