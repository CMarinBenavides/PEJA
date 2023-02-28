package com.archerprop.peja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping("/admin")
    public String registrarUsuarioA(@ModelAttribute("usuario") UsuarioRegistroDTO RegistroDTO) {
        usuarioService.guardar(RegistroDTO, "ADMIN");
        return "redirect:/index?success";
    }

    @PostMapping("/docente")
    public String registrarUsuarioD(@ModelAttribute("usuario") UsuarioRegistroDTO RegistroDTO) {
        usuarioService.guardar(RegistroDTO, "DOCENTE");
        return "redirect:/index?success";
    }

    @PostMapping("/estudiante")
    public String registrarUsuarioE(@ModelAttribute("usuario") UsuarioRegistroDTO RegistroDTO) {
        usuarioService.guardar(RegistroDTO, "ESTUDIANTE");
        return "redirect:/index?success";
    }

}
