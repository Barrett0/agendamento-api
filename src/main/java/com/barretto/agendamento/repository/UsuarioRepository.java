package com.barretto.agendamento.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barretto.agendamento.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
    Optional<Usuario> findByEmail (String email);
         
}
