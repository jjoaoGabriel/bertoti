package com.example.demo.service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // GET BY ID
    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // POST
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    // PUT
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());

        return repository.save(usuario);
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}