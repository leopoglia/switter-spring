package br.senai.sc.almoxarifado.controller;

import br.senai.sc.almoxarifado.dto.ChatDTO;
import br.senai.sc.almoxarifado.dto.PrivadoDTO;
import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Privado;
import br.senai.sc.almoxarifado.model.service.PrivadoService;
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
@RequestMapping("/api/privado")
public class PrivadoController {
    private PrivadoService privadoService;

    @GetMapping()
    public ResponseEntity<List<Privado>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(privadoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findById(@PathVariable(value = "codigo") Integer codigo) {
        Optional<Privado> chatOptional = privadoService.findById(codigo);

        if (chatOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar esse usuario");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(chatOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody PrivadoDTO privadoDTO) {

        Privado privado = new Privado();
        BeanUtils.copyProperties(privadoDTO, privado);


        return ResponseEntity.status(HttpStatus.CREATED).body(privadoService.save(privado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "codigo") Integer codigo) {

        if (!privadoService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar um usuario com esse codigo");
        }

        privadoService.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado.");
    }
}
