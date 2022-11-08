package br.senai.sc.almoxarifado.dto;

import lombok.Getter;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Getter
public class ChatDTO {

    private Date dataCriacao;
}
