package br.senai.sc.almoxarifado.model.service;

import br.senai.sc.almoxarifado.model.entities.Mensagem;
import br.senai.sc.almoxarifado.repository.MensagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MensagemService {
    private MensagemRepository mensagemRepository;

    public boolean existsById(Integer codigo) {
        return mensagemRepository.existsById(codigo);
    }

    public List<Mensagem> findAll() {
        return mensagemRepository.findAll();
    }

    public <S extends Mensagem> S save(S entity) {
        return mensagemRepository.save(entity);
    }

    public Optional<Mensagem> findById(Integer condigo) {
        return mensagemRepository.findById(condigo);
    }

    public void deleteById(Integer codigo) {
        mensagemRepository.deleteById(codigo);
    }
}
