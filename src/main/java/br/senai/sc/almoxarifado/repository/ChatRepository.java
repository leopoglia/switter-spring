package br.senai.sc.almoxarifado.repository;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
