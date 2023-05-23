package com.archerprop.peja.controller;

import java.security.Principal;
import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.archerprop.peja.dto.TareaDTO;
import com.archerprop.peja.entity.Tareas;
import com.archerprop.peja.entity.Usuario;
import com.archerprop.peja.service.UsuarioService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String user(Principal principal) {

        if (principal == null) {
            return "redirect:/logout";
        }

        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        String rol = usuario.getRoles().iterator().next().getName();
        if (rol.equals("DOCENTE")) {
            return "redirect:/user/docente";
        }
        if (rol.equals("ESTUDIANTE")) {
            return "redirect:/user/estudiante";
        }
        return "redirect:/logout";
    }

    @GetMapping("/docente")
    public String docente(Principal principal, Model model) {

        if (principal == null) {
            return "redirect:/logout";
        }
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        List<Tareas> tareas = usuarioService.listarTareasPorDocente(usuario.getCedula());
        List<Usuario> estudiantes = usuarioService.listarUsuariosEstudiante();
        model.addAttribute("modificarTarea", false);
        model.addAttribute("tareasPorDocente", tareas);
        model.addAttribute("estudiantes", estudiantes);
        return "pages/docente";
    }

    @GetMapping("/estudiante")
    public String estudiante(Principal principal, Model model) {

        if (principal == null) {
            return "redirect:/logout";
        }
        List<Usuario> docentes = usuarioService.listarUsuariosDocente();
        Map<Long, String> nombreDocentes = new HashMap<Long, String>();
        for (Usuario docente : docentes) {
            nombreDocentes.put(docente.getCedula(), docente.getNombre() + " " + docente.getApellido());
        }
        model.addAttribute("tareas", usuarioService.listarTareas());
        model.addAttribute("nombreDocentes", nombreDocentes);
        model.addAttribute("details", false);
        return "pages/estudiante";
    }

    @GetMapping("estudiante/tareas")
    public String tareas(Principal principal) {

        if (principal == null) {
            return "redirect:/logout";
        }

        return "pages/estudiante";
    }

    @ModelAttribute("tarea")
    public TareaDTO retornarNuevoTarea() {
        return new TareaDTO();
    }

    @PostMapping("/registrar/tarea")
    public String registrarTareas(@ModelAttribute("tarea") TareaDTO tarea, Principal principal) {
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        String fecha = tarea.getFechaEntrega();
        String hora = tarea.getHoraEntrega();

        Tareas tareaNueva = new Tareas();
        tareaNueva.setTitulo(tarea.getTitulo());
        tareaNueva.setDescripcion(tarea.getDescripcion());
        tareaNueva.setFechaEntrega(Date.valueOf(fecha));
        if (hora == null) {
            hora = "00:00:00";
        } else {
            hora = hora + ":00";
        }
        tareaNueva.setHoraEntrega(Time.valueOf(hora));
        tareaNueva.setDocente(usuario.getCedula());

        if (usuarioService.guardar(tareaNueva) != null) {
            return "redirect:/user/docente?successT#tools";
        }
        return "pages/docente";
    }

    @PostMapping("/modificar")
    public String modificarTarea(@ModelAttribute("tareaMod") TareaDTO tarea, Principal principal, Model model) {
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        String fecha = tarea.getFechaEntrega();
        String hora = tarea.getHoraEntrega();

        Tareas tareaNueva = new Tareas();
        tareaNueva.setId(tarea.getId());
        tareaNueva.setTitulo(tarea.getTitulo());
        tareaNueva.setDescripcion(tarea.getDescripcion());
        tareaNueva.setFechaEntrega(Date.valueOf(fecha));
        if (hora == null) {
            hora = "00:00:00";
        } else {
            hora = hora + ":00";
        }
        tareaNueva.setHoraEntrega(Time.valueOf(hora));
        tareaNueva.setDocente(usuario.getCedula());

        if (usuarioService.modificarTarea(tareaNueva)) {
            model.addAttribute("tareaMod", tareaNueva);
            model.addAttribute("modificarTarea", false);
            return "redirect:/user/docente?successChangeT#tools";
        }
        return "pages/docente";
    }

    @ModelAttribute("tareaMod")
    public TareaDTO retornarNuevoTareaMod() {
        return new TareaDTO();
    }

    @GetMapping("/docente/{id}")
    public String modificarTarea(@PathVariable("id") Long id, Model model, Principal principal) {
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        Tareas tarea = usuarioService.buscarTareaPorCedula(id);

        model.addAttribute("tareaMod", tarea);
        model.addAttribute("modificarTarea", true);
        model.addAttribute("tareasPorDocente", usuarioService.listarTareasPorDocente(usuario.getCedula()));

        return "pages/docente";
    }

    @GetMapping("/docente/{id}/delete")
    public String eliminarTarea(@PathVariable("id") Long id, Model model, Principal principal) {
        Usuario usuario = usuarioService.buscarUsuario(principal.getName());
        Tareas tarea = usuarioService.buscarTareaPorCedula(id);

        usuarioService.eliminarTarea(tarea);

        model.addAttribute("tareaMod", tarea);
        model.addAttribute("modificarTarea", true);
        model.addAttribute("tareasPorDocente", usuarioService.listarTareasPorDocente(usuario.getCedula()));

        return "redirect:/user/docente?successDeleteT#tools";
    }

    @GetMapping("/docente/cancel")
    public String cancelar(Model model) {
        Tareas tarea = null;
        model.addAttribute("tarea", tarea);
        return "redirect:/user/docente#tools";
    }

    @GetMapping("/estudiante/view/{id}")
    public String verTarea(@PathVariable("id") Long id, Model model) {
        Tareas tarea = usuarioService.buscarTarea(id);
        List<Usuario> docentes = usuarioService.listarUsuariosDocente();
        Map<Long, String> nombreDocentes = new HashMap<Long, String>();
        for (Usuario docente : docentes) {
            nombreDocentes.put(docente.getCedula(), docente.getNombre() + " " + docente.getApellido());
        }
        model.addAttribute("nombreDocentes", nombreDocentes);
        model.addAttribute("tareaView", tarea);
        model.addAttribute("details", true);
        return "pages/estudiante";
    }

    @GetMapping("/estudiante/back")
    public String volver(Model model) {

        Tareas tarea = null;

        model.addAttribute("tareaView", tarea);
        model.addAttribute("details", false);
        return "redirect:/user/estudiante#tools";
    }
}
