package br.senai.sc.almoxarifado.model.service;

import br.senai.sc.almoxarifado.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatService {
    private ChatRepository chatRepository;

}
