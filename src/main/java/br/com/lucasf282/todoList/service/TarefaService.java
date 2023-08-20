package br.com.lucasf282.todoList.service;

import br.com.lucasf282.todoList.entity.Tarefa;
import br.com.lucasf282.todoList.repository.TarefaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.*;

@Transactional
@ApplicationScoped
public class TarefaService {

    @Inject
    TarefaRepository repository;

    public void incluir(Tarefa tarefa) {
        repository.persist(tarefa);
    }

    public Optional<Tarefa> consultar(Long id) {
        return repository.findByIdOptional(id);
    }

    public List<Tarefa> listar() {
        return repository.listAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Tarefa tarefa) {
        repository.persist(tarefa);
    }

    public List<Tarefa> listarPorProjeto(Long idProjeto) {
        return repository.listarPorProjeto(idProjeto);
    }
}
