package br.com.lucasf282.todoList.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum StatusTarefaEnum {
    INDEFINIDO(0L, "Indefinido"),
    ABERTA(1L, "Aberta"),
    FAZENDO(2L, "Fazendo"),
    COMPLETA(3L, "Completa"),
    CANCELADA(4L, "Cancelada");

    private Long id;
    private String descricao;

    StatusTarefaEnum(Long id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public static StatusTarefaEnum of(Long id){
        return Arrays.stream(StatusTarefaEnum.values())
                .filter(statusTarefaEnum -> statusTarefaEnum.id.equals(id))
                .findFirst()
                .orElse(StatusTarefaEnum.INDEFINIDO);
    }

    public Long getId() {
        return id;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
