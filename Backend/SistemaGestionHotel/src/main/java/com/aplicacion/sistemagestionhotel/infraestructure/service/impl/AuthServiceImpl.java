package com.aplicacion.sistemagestionhotel.infraestructure.service.impl;

import com.aplicacion.sistemagestionhotel.application.Interfaces.IAuthService;
import com.aplicacion.sistemagestionhotel.domain.enums.Role;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.UsuarioEntity;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.auth.AuthResponse;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.auth.LoginRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.auth.RegisterRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.repository.UsuarioRepository;
import com.aplicacion.sistemagestionhotel.infraestructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }
        UsuarioEntity usuario = UsuarioEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .role(Role.USER)
                .build();
        usuarioRepository.save(usuario);
        String token = jwtUtil.generateToken(usuario.getUsername());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        UsuarioEntity usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        String token = jwtUtil.generateToken(usuario.getUsername());
        return new AuthResponse(token);
    }
}