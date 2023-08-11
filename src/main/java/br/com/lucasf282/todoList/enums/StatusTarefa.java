package br.com.lucasf282.todoList.enums;

import java.util.Arrays;

public enum StatusTarefa {
    INDEFINIDO(0L, "Indefinido"),
    ABERTA(1L, "Aberta"),
    FAZENDO(2L, "Fazendo"),
    COMPLETA(3L, "Completa"),
    CANCELADA(4L, "Cancelada");

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    private Long id;
    private String descricao;

    StatusTarefa(Long id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public StatusTarefa getByid(Long id){
        return Arrays.stream(StatusTarefa.values())
                .filter(statusTarefa -> statusTarefa.id.equals(id))
                .findFirst()
                .orElse(StatusTarefa.INDEFINIDO);
    }
}
