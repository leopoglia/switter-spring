package br.senai.sc.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "privado")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Privado {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_chat")
    Chat chat;

    @OneToOne
    @JoinColumn(name = "id_reciver")
    Usuario reciver;

    @OneToOne
    @JoinColumn(name = "id_sender")
    Usuario sender;
}
