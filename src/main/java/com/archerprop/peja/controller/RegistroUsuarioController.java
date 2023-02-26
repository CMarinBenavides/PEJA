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

    @PostMapping
    public String registrarUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO RegistroDTO) {
        usuarioService.guardar(RegistroDTO);
        return "redirect:/registro?success";
    }

}
