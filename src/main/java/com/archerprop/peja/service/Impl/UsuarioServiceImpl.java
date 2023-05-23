package com.archerprop.peja.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.Query;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.archerprop.peja.dto.UsuarioRegistroDTO;
import com.archerprop.peja.entity.Rol;
import com.archerprop.peja.entity.Tareas;
import com.archerprop.peja.entity.Usuario;
import com.archerprop.peja.repository.RoleRepositorio;
import com.archerprop.peja.repository.TareaRepositorio;
import com.archerprop.peja.repository.UsuarioRepositorio;
import org.springframework.transaction.annotation.Transactional;
import com.archerprop.peja.service.UsuarioService;
import java.util.regex.Matcher;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RoleRepositorio RoleRepositorio;

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO, String userRol) {
        if (usuarioRepositorio.existsByCorreo(registroDTO.getCorreo())) {
            return null;
        }
        Rol rol = RoleRepositorio.findByName(userRol);
        Collection<Rol> roles = Arrays.asList(rol);
        String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(registroDTO.getCorreo());
        if (registroDTO.getCedula() == null
                || registroDTO.getCedula().toString().length() <= 0
                || registroDTO.getCedula().toString().length() > 12
                || usuarioRepositorio.existsByCedula(registroDTO.getCedula())
                || registroDTO.getNombre() == null
                || registroDTO.getNombre().length() <= 0
                || registroDTO.getNombre().length() > 30
                || registroDTO.getNombre().matches(".*\\d.*")
                || registroDTO.getApellido() == null
                || registroDTO.getApellido().length() <= 0
                || registroDTO.getApellido().length() > 30
                || registroDTO.getApellido().matches(".*\\d.*")
                || registroDTO.getCorreo() == null
                || registroDTO.getCorreo().length() <= 0
                || registroDTO.getCorreo().length() > 50
                || !matcher.matches()
                || registroDTO.getClave() == null
                || registroDTO.getClave().length() <= 7
                || registroDTO.getClave().length() > 12) {
            return null;
        }
        Usuario usuario = new Usuario(
                registroDTO.getCedula(),
                registroDTO.getNombre(),
                registroDTO.getApellido(),
                registroDTO.getCorreo(),
                new BCryptPasswordEncoder().encode(registroDTO.getClave()),
                roles);
        return usuarioRepositorio.save(usuario);
    }// El método guardar es una función que guarda un nuevo usuario en una base de
     // datos. El método acepta un objeto UsuarioRegistroDTO que contiene los datos
     // del usuario y una cadena de texto userRol que representa el rol del
     // usuario.En otras palabras, este método acepta datos de registro de usuario,
     // comprueba si ya existe un usuario con el correo electrónico proporcionado,
     // crea un nuevo objeto Usuario con los datos proporcionados, guarda el objeto
     // Usuario en la base de datos y devuelve el objeto Usuario guardado.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(usuario.getCorreo(), usuario.getClave(), getAuthorities(usuario.getRoles()));
    }// Este método se utiliza para cargar los detalles de un usuario a través de su
     // correo electrónico. El método busca un objeto Usuario en la base de datos con
     // el correo electrónico especificado, crea un objeto UserDetails con los
     // detalles del usuario encontrado y devuelve este objeto UserDetails. Si no se
     // encuentra un usuario con el correo electrónico especificado, el método arroja
     // una excepción.

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }// Este método se utiliza para crear una lista de autoridades (GrantedAuthority)
     // a partir de una colección de roles (Rol). El método itera a través de la
     // colección de roles, crea un objeto SimpleGrantedAuthority para cada rol y los
     // agrega a una lista de autoridades. El método devuelve la lista de autoridades
     // creadas.

    @Override
    public Usuario buscarUsuario(String correo) {
        return usuarioRepositorio.findByCorreo(correo);
    }// Este método se utiliza para buscar un objeto Usuario en la base de datos a
     // través de su correo electrónico. El método busca un objeto Usuario en la base
     // de datos con el correo electrónico especificado, y devuelve el objeto Usuario
     // encontrado si existe. Si no se encuentra un usuario con el correo electrónico
     // especificado, el método devuelve nulo.

    @Override
    public List<Usuario> listarUsuariosAdmin() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Usuario> usuariosAdmin = usuarios.stream()
                .filter(usuario -> usuario.getRoles().stream().anyMatch(rol -> rol.getName().equals("ADMIN")))
                .collect(Collectors.toList());
        return usuariosAdmin;
    }// Este método se utiliza para obtener una lista de todos los usuarios que
     // tienen el rol de "ADMIN". El método busca todos los usuarios en la base de
     // datos y luego filtra solo aquellos que tienen el rol de "ADMIN". La lista
     // filtrada de usuarios con el rol de "ADMIN" se devuelve como resultado.

    @Override
    public List<Usuario> listarUsuariosDocente() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Usuario> usuariosDocente = usuarios.stream()
                .filter(usuario -> usuario.getRoles().stream().anyMatch(rol -> rol.getName().equals("DOCENTE")))
                .collect(Collectors.toList());
        return usuariosDocente;
    }// Este método se utiliza para obtener una lista de todos los usuarios que
     // tienen el rol de "DOCENTE". El método busca todos los usuarios en la base de
     // datos y luego filtra solo aquellos que tienen el rol de "DOCENTE". La lista
     // filtrada de usuarios con el rol de "DOCENTE" se devuelve como resultado.

    @Override
    public List<Usuario> listarUsuariosEstudiante() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<Usuario> usuariosEstudiante = usuarios.stream()
                .filter(usuario -> usuario.getRoles().stream().anyMatch(rol -> rol.getName().equals("ESTUDIANTE")))
                .collect(Collectors.toList());
        return usuariosEstudiante;
    }// Este método se utiliza para obtener una lista de todos los usuarios que
     // tienen el rol de "ESTUDIANTE". El método busca todos los usuarios en la base
     // de datos y luego filtra solo aquellos que tienen el rol de "ESTUDIANTE". La
     // lista filtrada de usuarios con el rol de "ESTUDIANTE" se devuelve como
     // resultado.

    @Override
    @Transactional
    public boolean eliminar(Usuario registroDTO) {
        try {
            String sql = "DELETE FROM public.usuarios_roles WHERE usuario_id=" + registroDTO.getId();
            Query query = entityManager.createNativeQuery(sql);
            query.executeUpdate();
            String sql1 = "DELETE FROM public.usuarios WHERE id=" + registroDTO.getId();
            Query query1 = entityManager.createNativeQuery(sql1);
            query1.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
            return false;
        }
    }// este método se utiliza para eliminar un objeto Usuario de la base de datos.
     // El método utiliza dos consultas SQL para eliminar el objeto Usuario y sus
     // relaciones de roles de la base de datos. Si se completa con éxito la
     // eliminación, el método devuelve true. Si ocurre un error, se imprime un
     // mensaje de error y el método devuelve false. El método utiliza una
     // transacción para asegurar que todas las operaciones de eliminación se
     // completen con éxito o se reviertan en caso de que ocurra un error.

    @Override
    public boolean modificar(UsuarioRegistroDTO registroDTO, String userRol) {
        Usuario usuarioR = usuarioRepositorio.findByCorreo(registroDTO.getCorreo());
        try {
            Rol rol = RoleRepositorio.findByName(userRol);
            Collection<Rol> roles = Arrays.asList(rol);
            Usuario usuario = new Usuario(
                    usuarioR.getId(),
                    registroDTO.getCedula(),
                    registroDTO.getNombre(),
                    registroDTO.getApellido(),
                    registroDTO.getCorreo(),
                    new BCryptPasswordEncoder().encode(registroDTO.getClave()),
                    roles);
            usuarioRepositorio.save(usuario);
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar el usuario: " + e.getMessage());
            return false;
        }
    }// Este método recibe un objeto UsuarioRegistroDTO y un String que indica el rol
     // del usuario. Busca en el repositorio de usuarios un usuario con el correo
     // electrónico proporcionado en el objeto UsuarioRegistroDTO y crea un nuevo
     // objeto Usuario con los datos actualizados del objeto UsuarioRegistroDTO y el
     // rol proporcionado. Luego guarda este nuevo objeto Usuario en el repositorio
     // de usuarios y devuelve verdadero si la operación fue exitosa y falso si
     // ocurrió algún error. Si ocurre algún error, imprime un mensaje de error
     // en la consola.

    @Override
    public Tareas guardar(Tareas tarea) {
        if (tareaRepositorio.existsByTitulo(tarea.getTitulo()) || tarea.getTitulo() == null
                || tarea.getDescripcion() == null || tarea.getDocente() == null) {
            return null;
        }
        return tareaRepositorio.save(tarea);
    }

    @Override
    public List<Tareas> listarTareas() {
        return tareaRepositorio.findAll();
    }

    @Override
    public List<Tareas> listarTareasPorDocente(Long idDocente) {
        List<Tareas> tareas = tareaRepositorio.findAll();
        List<Tareas> tareasDocente = tareas.stream()
                .filter(tarea -> tarea.getDocente().equals(idDocente))
                .collect(Collectors.toList());
        return tareasDocente;
    }

    @Override
    public Tareas buscarTarea(Long id) {
        return tareaRepositorio.findById(id).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorCedula(Long cedula) {
        return usuarioRepositorio.findByCedula(cedula);
    }

    @Override
    public Tareas buscarTareaPorCedula(Long id) {
        return tareaRepositorio.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarTarea(Tareas tarea) {
        try {
            tareaRepositorio.delete(tarea);
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar la tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarTarea(Tareas tarea) {
        Tareas t = tareaRepositorio.findByTitulo(tarea.getTitulo());
        try {
            Tareas tareaNueva = new Tareas(
                    t.getId(),
                    tarea.getTitulo(),
                    tarea.getDescripcion(),
                    tarea.getDocente(),
                    tarea.getFechaEntrega(),
                    tarea.getHoraEntrega());
            tareaRepositorio.save(tareaNueva);
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar la tarea: " + e.getMessage());
            return false;
        }
    }
}
