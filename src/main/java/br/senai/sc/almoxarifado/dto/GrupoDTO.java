package br.senai.sc.almoxarifado.dto;

import br.senai.sc.almoxarifado.model.entities.Usuario;
import lombok.Getter;
import java.util.Set;

@Getter
public class GrupoDTO {

    private String titulo;

    private String descricao;

    Set<Usuario> usuarios;
}
