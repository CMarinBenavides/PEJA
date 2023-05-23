package com.archerprop.peja.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.entity.Tareas;
import com.archerprop.peja.entity.Usuario;

public interface UsuarioService extends UserDetailsService {

    public Usuario guardar(UsuarioRegistroDTO usuarioDTO, String rol);

    public Usuario buscarUsuario(String correo);

    public Usuario buscarUsuarioPorCedula(Long cedula);

    public List<Usuario> listarUsuariosAdmin();

    public List<Usuario> listarUsuariosDocente();

    public List<Usuario> listarUsuariosEstudiante();

    public boolean eliminar(Usuario usuarioDTO);

    public boolean modificar(UsuarioRegistroDTO usuarioDTO, String rol);

    public Tareas guardar(Tareas tareas);

    public List<Tareas> listarTareas();

    public List<Tareas> listarTareasPorDocente(Long idDocente);

    public Tareas buscarTarea(Long id);

    public Tareas buscarTareaPorCedula(Long id);

    public boolean eliminarTarea(Tareas Tarea);

    public boolean modificarTarea(Tareas Tarea);

}// La interfaz extiende la interfaz UserDetailsService, lo que significa que
 // cualquier clase que implemente UsuarioService debe proporcionar una
 // implementación para el método loadUserByUsername que recibe como parámetro el
 // nombre de usuario y devuelve detalles de usuario.

// Los métodos definidos en la interfaz UsuarioService son:

// guardar: Recibe un objeto UsuarioRegistroDTO y un nombre de rol como
// parámetros y devuelve un objeto Usuario después de guardarlo en la base de
// datos.buscarUsuario: Recibe un correo electrónico como parámetro y devuelve
// un objeto Usuario que tiene ese correo electrónico.
// listarUsuariosAdmin: Devuelve una lista de objetos Usuario que tienen el rol
// de administrador.
// listarUsuariosDocente: Devuelve una lista de objetos Usuario que tienen el
// rol de docente.
// istarUsuariosEstudiante: Devuelve una lista de objetos Usuario que tienen el
// rol de estudiante.
// eliminar: Recibe un objeto Usuario como parámetro y elimina ese usuario de la
// base de datos.
// modificar: Recibe un objeto UsuarioRegistroDTO y un nombre de rol como
// parámetros y modifica el usuario correspondiente en la base de datos.
