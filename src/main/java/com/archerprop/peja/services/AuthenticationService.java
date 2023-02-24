package com.archerprop.peja.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.archerprop.peja.controller.AuthenticationRequest;
import com.archerprop.peja.controller.AuthenticationResponse;
import com.archerprop.peja.controller.RegisterRequest;
import com.archerprop.peja.entity.Role;
import com.archerprop.peja.entity.Usuarios;
import com.archerprop.peja.repositories.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UsuarioRepositorio usuarioRepositorio;

        private final PasswordEncoder passwordEncoder;

        private final JwtService jwtService;

        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                var usuario = Usuarios.builder()
                                .nombre(request.getNombre())
                                .apellido(request.getApellido())
                                .correo(request.getCorreo())
                                .clave(passwordEncoder.encode(request.getClave()))
                                .rol(Role.USER)
                                .build();
                usuarioRepositorio.save(usuario);
                var jwtToken = jwtService.generateToken(usuario);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getCorreo(),
                                                request.getClave()));
                var usuario = usuarioRepositorio.findByCorreo(request.getCorreo())
                                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
                var jwtToken = jwtService.generateToken(usuario);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

}
