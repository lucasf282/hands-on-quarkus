package br.com.lucasf282.todoList.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;
}
