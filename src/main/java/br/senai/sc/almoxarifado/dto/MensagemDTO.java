package br.senai.sc.almoxarifado.dto;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Usuario;
import lombok.Getter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
public class MensagemDTO {

    @NotBlank
    private String body;

    private Date dataCriacao;

    Chat chat;

    Usuario author;
}
