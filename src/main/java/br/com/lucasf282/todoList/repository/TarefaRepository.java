package br.com.lucasf282.todoList.repository;

import br.com.lucasf282.todoList.entity.Tarefa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TarefaRepository implements PanacheRepository<Tarefa> {
}
