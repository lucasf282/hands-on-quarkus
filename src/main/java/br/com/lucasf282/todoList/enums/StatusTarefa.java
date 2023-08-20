package br.com.lucasf282.todoList.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum StatusTarefa {
    INDEFINIDO(0L, "Indefinido"),
    ABERTA(1L, "Aberta"),
    FAZENDO(2L, "Fazendo"),
    COMPLETA(3L, "Completa"),
    CANCELADA(4L, "Cancelada");

    private Long id;
    private String descricao;

    StatusTarefa(Long id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public static StatusTarefa of(Long id){
        return Arrays.stream(StatusTarefa.values())
                .filter(statusTarefa -> statusTarefa.id.equals(id))
                .findFirst()
                .orElse(StatusTarefa.INDEFINIDO);
    }

    public Long getId() {
        return id;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }
}
