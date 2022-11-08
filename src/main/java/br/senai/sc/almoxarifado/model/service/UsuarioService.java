package br.senai.sc.almoxarifado.model.service;

import br.senai.sc.almoxarifado.model.entities.Usuario;
import br.senai.sc.almoxarifado.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public boolean existsById(Integer codigo) {
        return usuarioRepository.existsById(codigo);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public <S extends Usuario> S save(S entity) {
        return usuarioRepository.save(entity);
    }

    public Optional<Usuario> findById(Integer condigo) {
        return usuarioRepository.findById(condigo);
    }

    public Optional<Usuario> findByNome(String nome){return usuarioRepository.findByNome(nome);}

    public void deleteById(Integer codigo) {
        usuarioRepository.deleteById(codigo);
    }

    public Usuario findBySenha(String senha){ return usuarioRepository.findBySenha(senha); }

}
