package br.senai.sc.almoxarifado.model.entities;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@AllArgsConstructor @NoArgsConstructor()
@Getter @Setter @ToString
@EqualsAndHashCode
public class Usuario {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String senha;

    @Column(length = 150, nullable = false, unique = true)
    private String email;


}
