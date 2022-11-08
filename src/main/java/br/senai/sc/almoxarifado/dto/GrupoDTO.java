package br.senai.sc.almoxarifado.dto;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Usuario;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class GrupoDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    Set<Usuario> usuarios;
}
