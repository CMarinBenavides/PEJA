package com.archerprop.peja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.service.UsuarioService;
import com.archerprop.peja.entity.Usuario;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Retorna un nuevo objeto UsuarioRegistroDTO para ser utilizado en el
     * formulario de registro.
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
     * @param RegistroDTO Un objeto UsuarioRegistroDTO que contiene la información
     *                    del usuario a registrar.
     * @return Redirige a la página "admin" con un mensaje de éxito o fracaso.
     */
    @PostMapping("/{rol}")
    public String registrarUsuario(@ModelAttribute("usuarioresgistro") UsuarioRegistroDTO RegistroDTO,
            @PathVariable("rol") String rol) {
        if (rol.equals("admin")) {
            try {
                if (usuarioService.guardar(RegistroDTO, "ADMIN") != null) {
                    return "redirect:/admin?successA#tools";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureA#tools";
            }
            return "redirect:/admin?failureA#tools";
        } else if (rol.equals("docente")) {
            try {
                if (usuarioService.guardar(RegistroDTO, "DOCENTE") != null) {
                    return "redirect:/admin?successD#tools";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureD#tools";
            }
            return "redirect:/admin?failureD#tools";
        } else if (rol.equals("estudiante")) {
            try {
                if (usuarioService.guardar(RegistroDTO, "ESTUDIANTE") != null) {
                    return "redirect:/admin?successE#tools";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureE#tools";
            }
            return "redirect:/admin?failureE#tools";
        } else if (rol.equals("superadmin")) {
            try {
                if (usuarioService.guardar(RegistroDTO, "SUPERADMIN") != null) {
                    return "redirect:/form?successSA#tools";
                }
            } catch (Exception e) {
                return "redirect:/form?failureSA#tools";
            }
            return "redirect:/form?failureSA#tools";
        }
        return "redirect:/admin?failureE";
    }

    /**
     * Modifica un usuario con el rol "ADMIN".
     *
     * @param RegistroDTO Un objeto UsuarioRegistroDTO que contiene la información
     *                    del usuario a modificar.
     * @param model       El modelo que se utilizará para agregar atributos a la
     *                    vista.
     * @return Redirige a la página "admin" con un mensaje de éxito o fracaso.
     */
    @PostMapping("/admin/mod")
    public String modificarUsuario(@ModelAttribute("usuarioMod") UsuarioRegistroDTO RegistroDTO, Model model) {
        Usuario usuarioR = usuarioService.buscarUsuario(RegistroDTO.getCorreo());
        String rol = usuarioR.getRoles().iterator().next().getName();

        if (rol.equals("ADMIN")) {
            try {
                if (usuarioService.modificar(RegistroDTO, "ADMIN")) {
                    Usuario usuario = null;
                    model.addAttribute("usuarioMod", usuario);
                    model.addAttribute("modificarA", false);
                    model.addAttribute("rol", "SUPERADMIN");
                    return "redirect:/admin?successChangeA#tools";
                }
            } catch (Exception e) {
                return "redirect:/admin?failure#tools";
            }
            return "redirect:/admin?failureA#tools";
        }
        if (rol.equals("DOCENTE")) {
            try {
                if (usuarioService.modificar(RegistroDTO, "DOCENTE")) {
                    Usuario usuario = null;
                    model.addAttribute("usuarioMod", usuario);
                    model.addAttribute("modificarD", false);
                    model.addAttribute("rol", "SUPERADMIN");
                    return "redirect:/admin?successChangeD#tools";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureD#tools";
            }
            return "redirect:/admin?failureD#tools";
        }
        if (rol.equals("ESTUDIANTE")) {
            try {
                if (usuarioService.modificar(RegistroDTO, "ESTUDIANTE")) {
                    Usuario usuario = null;
                    model.addAttribute("usuarioMod", usuario);
                    model.addAttribute("modificarE", false);
                    model.addAttribute("rol", "SUPERADMIN");
                    return "redirect:/admin?successChangeE#tools";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureE#tools";
            }
            return "redirect:/admin?failureE#tools";
        }
        return "redirect:/admin?failureA#tools";
    }

}
