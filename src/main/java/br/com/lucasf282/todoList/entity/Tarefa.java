package br.com.lucasf282.todoList.entity;

import br.com.lucasf282.todoList.enums.StatusTarefa;
import jakarta.persistence.*;

@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @GeneratedValue
    public Long id;
    public String nome;
    public String descricao;
    @Enumerated(EnumType.ORDINAL)
    public StatusTarefa status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    public Projeto projeto;

}

