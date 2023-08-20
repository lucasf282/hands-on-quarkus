package br.com.lucasf282.todoList.repository;

import br.com.lucasf282.todoList.entity.Projeto;
import br.com.lucasf282.todoList.enums.DirecaoOrdemEnum;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProjetoRepository implements PanacheRepository<Projeto> {
    public List<Projeto> list(String orderBy, DirecaoOrdemEnum direction, int page, int pageSize) {
        return findAll(Sort.by(orderBy, Sort.Direction.valueOf(direction.getDescricao())))
                .page(page, pageSize)
                .list();
    }
}
