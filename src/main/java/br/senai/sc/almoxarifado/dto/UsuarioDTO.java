package br.senai.sc.almoxarifado.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class UsuarioDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String senha;

    @NotBlank @Email
    private String email;

}