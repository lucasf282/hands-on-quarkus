package br.com.lucasf282.todoList.service;

import br.com.lucasf282.todoList.entity.Projeto;
import br.com.lucasf282.todoList.entity.Tarefa;
import br.com.lucasf282.todoList.enums.DirecaoOrdemEnum;
import br.com.lucasf282.todoList.repository.ProjetoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProjetoService {

    @Inject
    ProjetoRepository repository;

    @Inject
    TarefaService tarefaService;

    public void incluir(Projeto projeto) {
        repository.persist(projeto);
    }

    public Optional<Projeto> consultar(Long id) {
        return repository.findByIdOptional(id);
    }

    public List<Projeto> listar(String orderBy, DirecaoOrdemEnum direction, int page, int pageSize) {
        return repository.list(orderBy, direction, page, pageSize);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Projeto projeto) {
        repository.persist(projeto);
    }

    public List<Tarefa> listarPorProjeto(Long id) {
        return tarefaService.listarPorProjeto(id);
    }
}
