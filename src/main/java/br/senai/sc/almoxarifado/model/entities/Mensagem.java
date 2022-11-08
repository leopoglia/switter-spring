package br.senai.sc.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mensagem")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Mensagem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String body;

    @Column(length = 100, nullable = false)
    private Date dataCriacao;

    @OneToOne
    @JoinColumn(name = "id_chat")
    Chat chat;

    @OneToOne
    @JoinColumn(name = "id_author")
    Usuario author;


}
