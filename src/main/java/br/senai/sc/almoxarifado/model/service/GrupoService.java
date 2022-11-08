package br.senai.sc.almoxarifado.model.service;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Grupo;
import br.senai.sc.almoxarifado.repository.ChatRepository;
import br.senai.sc.almoxarifado.repository.GrupoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GrupoService {
    private GrupoRepository grupoRepository;

    public boolean existsById(Integer codigo) {
        return grupoRepository.existsById(codigo);
    }

    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    public <S extends Grupo> S save(S entity) {
        return grupoRepository.save(entity);
    }

    public Optional<Grupo> findById(Integer condigo) {
        return grupoRepository.findById(condigo);
    }

    public void deleteById(Integer codigo) {
        grupoRepository.deleteById(codigo);
    }
}
