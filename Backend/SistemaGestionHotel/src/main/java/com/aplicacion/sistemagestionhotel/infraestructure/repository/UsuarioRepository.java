package com.aplicacion.sistemagestionhotel.infraestructure.repository;
import com.aplicacion.sistemagestionhotel.infraestructure.Persitence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsername(String username);
}
