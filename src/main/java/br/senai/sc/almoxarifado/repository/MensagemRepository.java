package br.senai.sc.almoxarifado.repository;

import br.senai.sc.almoxarifado.model.entities.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
}
