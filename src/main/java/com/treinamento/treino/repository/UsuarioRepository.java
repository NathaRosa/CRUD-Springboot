package com.treinamento.treino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.treino.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
