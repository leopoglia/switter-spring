package br.senai.sc.almoxarifado.repository;


import br.senai.sc.almoxarifado.model.entities.Privado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivadoRepository extends JpaRepository<Privado, Integer> {
}
