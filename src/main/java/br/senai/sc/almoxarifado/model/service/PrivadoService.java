package br.senai.sc.almoxarifado.model.service;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Privado;
import br.senai.sc.almoxarifado.repository.PrivadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrivadoService {
    private PrivadoRepository privadoRepository;

    public boolean existsById(Integer codigo) {
        return privadoRepository.existsById(codigo);
    }

    public List<Privado> findAll() {
        return privadoRepository.findAll();
    }

    public <S extends Privado> S save(S entity) {
        return privadoRepository.save(entity);
    }

    public Optional<Privado> findById(Integer condigo) {
        return privadoRepository.findById(condigo);
    }

    public void deleteById(Integer codigo) {
        privadoRepository.deleteById(codigo);
    }

}
