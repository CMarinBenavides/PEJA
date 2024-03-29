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

/**
 * Controlador para la funcionalidad de administrador
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    /**
     * Método que maneja la solicitud GET para la página de administración
     * 
     * @param model     objeto Model que se utiliza para agregar atributos a la
     *                  vista
     * @param principal objeto Principal que representa al usuario autenticado
     *                  actualmente
     * @return vista admin si el usuario está autenticado, de lo contrario redirige
     *         a la página de inicio de sesión
     */
    @GetMapping
    public String admin(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/login";
        }
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        List<Usuario> usuariosA = usuarioService.listarUsuariosAdmin();
        List<Usuario> usuariosD = usuarioService.listarUsuariosDocente();
        List<Usuario> usuariosE = usuarioService.listarUsuariosEstudiante();
        String rol = usuario.getRoles().iterator().next().getName();
        model.addAttribute("usuario", usuario);
        model.addAttribute("rol", rol);
        model.addAttribute("usuariosAdmin", usuariosA);
        model.addAttribute("usuariosDocente", usuariosD);
        model.addAttribute("usuariosEstudiante", usuariosE);
        model.addAttribute("modificarA", false);
        model.addAttribute("modificarD", false);
        model.addAttribute("modificarE", false);

        return "pages/admin";
    }

    /**
     * Método que devuelve un nuevo objeto UsuarioRegistroDTO para ser utilizado en
     * la vista
     *
     * @return nuevo objeto UsuarioRegistroDTO
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Método que devuelve un nuevo objeto UsuarioRegistroDTO para ser utilizado en
     * la vista
     * 
     * @return nuevo objeto UsuarioRegistroDTO
     */
    @ModelAttribute("usuarioregistro")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @ModelAttribute("usuarioMod")
    public UsuarioRegistroDTO retornarModificacionUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Método que maneja la solicitud GET para modificar un usuario
     * 
     * @param correo correo electrónico del usuario a modificar
     * @param model  objeto Model que se utiliza para agregar atributos a la vista
     * @return vista admin con el objeto UsuarioRegistroDTO correspondiente y la
     *         bandera "modificar" establecida en true
     */
    @GetMapping("/{correo}")
    public String modificarUsuario(@PathVariable String correo, Model model, Principal principal) {
        System.out.println("correo: " + correo);
        Usuario usuarioM = usuarioService.buscarUsuario(correo);
        Usuario usuarioSesion = usuarioService.buscarUsuario(principal.getName());
        String rol = usuarioSesion.getRoles().iterator().next().getName();
        String rolM = usuarioM.getRoles().iterator().next().getName();
        List<Usuario> usuariosA = usuarioService.listarUsuariosAdmin();
        List<Usuario> usuariosD = usuarioService.listarUsuariosDocente();
        List<Usuario> usuariosE = usuarioService.listarUsuariosEstudiante();
        model.addAttribute("usuarioMod", usuarioM);
        model.addAttribute("usuariosAdmin", usuariosA);
        model.addAttribute("usuariosDocente", usuariosD);
        model.addAttribute("usuariosEstudiante", usuariosE);
        model.addAttribute("modificarA", false);
        model.addAttribute("modificarD", false);
        model.addAttribute("modificarE", false);
        model.addAttribute("rol", rol);
        if (rolM.equals("ADMIN")) {
            model.addAttribute("modificarA", true);
            return "pages/admin";
        } else if (rolM.equals("DOCENTE")) {
            model.addAttribute("modificarD", true);
            return "pages/admin";
        } else if (rolM.equals("ESTUDIANTE")) {
            model.addAttribute("modificarE", true);
            return "pages/admin";
        }
        return "pages/admin";
    }

    /**
     * Método que maneja la solicitud GET para eliminar un usuario
     *
     * @param correo correo electrónico del usuario a eliminar
     * @param model  objeto Model que se utiliza para agregar atributos a la vista
     * @return redirige a la página admin con la bandera "successDelete" establecida
     *         si la eliminación fue exitosa, de lo contrario redirige a la página
     *         admin con la bandera "failure" establecida
     */
    @GetMapping("/{correo}/delete")
    public String eliminarUsuario(@PathVariable String correo, Model model) {
        Usuario usuarioR = usuarioService.buscarUsuario(correo);
        String rol = usuarioR.getRoles().iterator().next().getName();
        if (rol.equals("ADMIN")) {
            try {
                if (usuarioService.eliminar(usuarioR)) {
                    Usuario usuario = null;
                    model.addAttribute("usuarioregistro", usuario);
                    return "redirect:/admin?successDeleteA";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureA";
            }
            return "redirect:/admin?failureA";
        } else if (rol.equals("DOCENTE")) {
            try {
                if (usuarioService.eliminar(usuarioR)) {
                    Usuario usuario = null;
                    model.addAttribute("usuarioregistro", usuario);
                    return "redirect:/admin?successDeleteD";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureD";
            }
            return "redirect:/admin?failureD";
        } else if (rol.equals("ESTUDIANTE")) {
            try {
                if (usuarioService.eliminar(usuarioR)) {
                    Usuario usuario = null;
                    model.addAttribute("usuarioregistro", usuario);
                    return "redirect:/admin?successDeleteE";
                }
            } catch (Exception e) {
                return "redirect:/admin?failureE";
            }
            return "redirect:/admin?failureE";
        }
        return "redirect:/admin?failureA";
    }

    @GetMapping("/cancel")
    public String cancelar(Model model) {
        Usuario usuario = null;
        model.addAttribute("usuarioregistro", usuario);
        return "redirect:/admin#tools";
    }
}
