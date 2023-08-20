package br.com.lucasf282.todoList.repository;

import br.com.lucasf282.todoList.entity.Tarefa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TarefaRepository implements PanacheRepository<Tarefa> {

    public List<Tarefa> listarPorProjeto(Long idProjeto) {
        Map<String, Object> params = new HashMap<>();
        params.put("idProjeto", idProjeto);
        return list("projeto.id = :idProjeto", Sort.by("id", Sort.Direction.Ascending), params);
    }
}
