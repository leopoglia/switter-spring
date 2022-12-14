package br.senai.sc.almoxarifado.repository;

import br.senai.sc.almoxarifado.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findBySenha(String senha);

    Optional<Usuario> findByNome(String nome);
}
