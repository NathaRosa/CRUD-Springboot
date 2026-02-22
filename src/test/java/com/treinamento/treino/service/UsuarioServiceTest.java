package com.treinamento.treino.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.treinamento.treino.dto.UsuarioDTO;
import com.treinamento.treino.model.Usuario;
import com.treinamento.treino.repository.UsuarioRepository;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    public UsuarioServiceTest() { MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarUsuarioQuandoIdExistir() {

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Nathã");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        UsuarioDTO usuarioDTO = usuarioService.buscarPorId(1L).orElse(null);

        assertNotNull(usuarioDTO);
        assertEquals("Nathã", usuarioDTO.getNome());

        
    }
}
