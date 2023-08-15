package br.com.lucasf282.todoList.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue
    public Long id;
    public String nome;
    public String descricao;

    @OneToMany(mappedBy = "projeto")
    public List<Tarefa> tarefas;
}
