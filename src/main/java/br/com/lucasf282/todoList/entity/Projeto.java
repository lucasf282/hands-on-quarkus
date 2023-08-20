package br.com.lucasf282.todoList.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY)
    private List<Tarefa> tarefas;
}
