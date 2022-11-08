package br.senai.sc.almoxarifado.model.service;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Usuario;
import br.senai.sc.almoxarifado.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChatService {
    private ChatRepository chatRepository;

    public boolean existsById(Integer codigo) {
        return chatRepository.existsById(codigo);
    }

    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    public <S extends Chat> S save(S entity) {
        return chatRepository.save(entity);
    }

    public Optional<Chat> findById(Integer condigo) {
        return chatRepository.findById(condigo);
    }

    public void deleteById(Integer codigo) {
        chatRepository.deleteById(codigo);
    }

}
