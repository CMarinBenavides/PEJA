package com.archerprop.peja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.services.UsuarioService;

@Controller
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UsuarioService userService;

    @RequestMapping("/")
    public String index(Model model) {
        return "admin";
    }
}
