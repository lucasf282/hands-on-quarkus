package br.com.lucasf282.todoList.entity;

import br.com.lucasf282.todoList.enums.StatusTarefaEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.ORDINAL)
    private StatusTarefaEnum status;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_projeto", insertable=false, updatable=false, nullable = false)
    private Projeto projeto;
    private Long id_projeto;
}

