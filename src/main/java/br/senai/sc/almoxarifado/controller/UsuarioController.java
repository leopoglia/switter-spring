package br.senai.sc.almoxarifado.controller;

import br.senai.sc.almoxarifado.dto.UsuarioDTO;
import br.senai.sc.almoxarifado.model.entities.Usuario;
import br.senai.sc.almoxarifado.model.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioService pessoaService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(pessoaService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> findById(@PathVariable(value = "codigo") Integer codigo) {
        Optional<Usuario> pessoaOptional = pessoaService.findById(codigo);

        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar esse usuario");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(pessoaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody UsuarioDTO usuarioDTO) {

        Usuario pessoa = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, pessoa);


        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "codigo") Integer codigo) {

        if (!pessoaService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar um usuario com esse codigo");
        }

        pessoaService.deleteById(codigo);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado.");
    }

    @Modifying
    @Transactional
    @PutMapping("/{codigo}")
    public ResponseEntity<Object> update(@PathVariable(value = "codigo") Integer codigo, @RequestBody @Valid UsuarioDTO usuarioDTO) {

        if (!pessoaService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO! Não foi possível encontrar esse usuario");
        }

        Optional<Usuario> pessoaOptional = pessoaService.findById(codigo);

        Usuario usuario = pessoaOptional.get();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(usuario));
    }
}