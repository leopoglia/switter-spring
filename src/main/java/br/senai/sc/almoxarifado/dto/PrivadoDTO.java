package br.senai.sc.almoxarifado.dto;

import br.senai.sc.almoxarifado.model.entities.Chat;
import br.senai.sc.almoxarifado.model.entities.Usuario;
import lombok.Getter;

@Getter
public class PrivadoDTO {

    private Chat chat;
    private Usuario reciver;
    private Usuario sender;
}
