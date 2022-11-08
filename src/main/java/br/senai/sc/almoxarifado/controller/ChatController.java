package br.senai.sc.almoxarifado.controller;

import br.senai.sc.almoxarifado.model.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/api/chat")
public class ChatController {
    private ChatService chatService;
}
