package br.senai.sc.almoxarifado.controller;

import br.senai.sc.almoxarifado.dto.ChatDTO;
import br.senai.sc.almoxarifado.dto.GrupoDTO;
import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Grupo;
import br.senai.sc.almoxarifado.model.service.ChatService;
import br.senai.sc.almoxarifado.model.service.GrupoService;
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
@RequestMapping("/api/grupo")
public class GrupoController {
    private GrupoService grupoService;

    @GetMapping()
    public ResponseEntity<List<Grupo>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(grupoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findById(@PathVariable(value = "codigo") Integer codigo) {
        Optional<Grupo> chatOptional = grupoService.findById(codigo);

        if (chatOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar esse usuario");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(chatOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody GrupoDTO grupoDTO) {

        Grupo grupo = new Grupo();
        BeanUtils.copyProperties(grupoDTO, grupo);


        return ResponseEntity.status(HttpStatus.CREATED).body(grupoService.save(grupo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "codigo") Integer codigo) {

        if (!grupoService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar um usuario com esse codigo");
        }

        grupoService.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado.");
    }
}
