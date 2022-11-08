package br.senai.sc.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "chat")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Chat {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(length = 100, nullable = false)
    private Timestamp creat_at;
}
