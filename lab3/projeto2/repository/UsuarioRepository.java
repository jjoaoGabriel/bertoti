package com.exemplo.projeto1.repository;

import com.exemplo.projeto1.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}