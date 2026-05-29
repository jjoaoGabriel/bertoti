package com.exemplo.projeto1.service;

import com.exemplo.projeto1.entity.Usuario;
import com.exemplo.projeto1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioNovo) {

        Usuario usuario = repository.findById(id).orElseThrow();

        usuario.setNome(usuarioNovo.getNome());
        usuario.setEmail(usuarioNovo.getEmail());

        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}