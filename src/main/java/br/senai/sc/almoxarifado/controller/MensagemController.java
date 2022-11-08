package br.senai.sc.almoxarifado.controller;

import br.senai.sc.almoxarifado.dto.MensagemDTO;
import br.senai.sc.almoxarifado.dto.PrivadoDTO;
import br.senai.sc.almoxarifado.model.entities.Mensagem;
import br.senai.sc.almoxarifado.model.entities.Privado;
import br.senai.sc.almoxarifado.model.service.GrupoService;
import br.senai.sc.almoxarifado.model.service.MensagemService;
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
@RequestMapping("/api/mensagem")
public class MensagemController {
    private MensagemService mensagemService;

    @GetMapping()
    public ResponseEntity<List<Mensagem>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(mensagemService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findById(@PathVariable(value = "codigo") Integer codigo) {
        Optional<Mensagem> chatOptional = mensagemService.findById(codigo);

        if (chatOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar esse usuario");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(chatOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody MensagemDTO mensagemDTO) {

        Mensagem mensagem = new Mensagem();
        BeanUtils.copyProperties(mensagemDTO, mensagem);


        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemService.save(mensagem));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "codigo") Integer codigo) {

        if (!mensagemService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar um usuario com esse codigo");
        }

        mensagemService.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado.");
    }
}
