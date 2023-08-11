package br.com.lucasf282.todoList.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Projeto")
public class ProjetoEntity {
    @Id
    @GeneratedValue
    public Long id;
    public String nome;
    public String descricao;

    @OneToMany(mappedBy = "projeto")
    public List<TarefaEntity> tarefas;
}
