package com.aplicacion.sistemagestionhotel.application.Interfaces;

import com.aplicacion.sistemagestionhotel.infraestructure.dto.auth.AuthResponse;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.auth.LoginRequest;
import com.aplicacion.sistemagestionhotel.infraestructure.dto.auth.RegisterRequest;

public interface IAuthService {

    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
