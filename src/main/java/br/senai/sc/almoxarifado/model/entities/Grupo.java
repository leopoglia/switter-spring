package br.senai.sc.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "grupo")
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Grupo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(length = 100)
    String titulo;

    @Column(length = 100)
    String descricao;

    @ManyToMany
    @JoinTable(
            name = "group_users",
            joinColumns = @JoinColumn(name = "grupo"),
            inverseJoinColumns = @JoinColumn(name = "usuario"))
    Set<Usuario> usuarios;

}
