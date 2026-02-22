package com.treinamento.treino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.treinamento.treino.dto.UsuarioDTO;
import com.treinamento.treino.exception.RecursoNaoEncontradoException;
import com.treinamento.treino.model.Usuario;
import com.treinamento.treino.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO converterParaDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getNome());
    }

    public UsuarioDTO salvar(Usuario usuario) {
        Usuario usuarioCriado = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioCriado);
    }

    public Page<UsuarioDTO> listar(Pageable pageable) {

        return usuarioRepository.findAll(pageable)
                .map(this::converterParaDTO);
    }

    public Optional<UsuarioDTO> buscarPorId(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário com id " + id + " não encontrado"));
                
        return Optional.of(converterParaDTO(usuario));
    }

    public List<UsuarioDTO> buscarPorNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public UsuarioDTO atualizar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setIdade(usuarioAtualizado.getIdade());

                    var usuarioSalvo = usuarioRepository.save(usuario);

                    return converterParaDTO(usuarioSalvo);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletar(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}