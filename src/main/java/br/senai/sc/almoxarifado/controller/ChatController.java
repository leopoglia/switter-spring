package br.senai.sc.almoxarifado.controller;

import br.senai.sc.almoxarifado.dto.ChatDTO;
import br.senai.sc.almoxarifado.dto.UsuarioDTO;
import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Usuario;
import br.senai.sc.almoxarifado.model.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/api/chat")
public class ChatController {
    private ChatService chatService;

    @GetMapping()
    public ResponseEntity<List<Chat>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(chatService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findById(@PathVariable(value = "codigo") Integer codigo) {
        Optional<Chat> chatOptional = chatService.findById(codigo);

        if (chatOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar esse usuario");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(chatOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ChatDTO chatDTO) {

        Chat chat = new Chat();
        BeanUtils.copyProperties(chatDTO, chat);


        return ResponseEntity.status(HttpStatus.CREATED).body(chatService.save(chat));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "codigo") Integer codigo) {

        if (!chatService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar um usuario com esse codigo");
        }

        chatService.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado.");
    }
}
