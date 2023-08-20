package br.com.lucasf282.todoList.enums;

public enum DirecaoOrdemEnum {
    ASC( "Ascending"),
    DESC( "Descending");
    private String descricao;

    DirecaoOrdemEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
