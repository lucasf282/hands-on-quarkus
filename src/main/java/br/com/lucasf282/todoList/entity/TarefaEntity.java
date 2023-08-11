package br.com.lucasf282.todoList.entity;

import br.com.lucasf282.todoList.enums.StatusTarefa;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.*;

@Entity
@Table(name = "Tarefa")
public class TarefaEntity {
    @Id
    @GeneratedValue
    public Long id;
    public String nome;
    public String descricao;
    @Enumerated(EnumType.ORDINAL)
    public StatusTarefa status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    public ProjetoEntity projeto;

}

