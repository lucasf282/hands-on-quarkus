package br.com.lucasf282.todoList.service;

import br.com.lucasf282.todoList.entity.Tarefa;
import br.com.lucasf282.todoList.repository.TarefaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

@Transactional
@RequestScoped
public class TarefaService {

    @Inject
    TarefaRepository repository;
    @Inject
    NotificacaoService notificacaoService;

    public void incluir(Tarefa tarefa) {
        repository.persist(tarefa);
        try {
            notificacaoService.notificar("tarefas", "Nova Tarefa: " + tarefa.getNome());
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Tarefa> consultar(Long id) {
        notificacaoService.messageReceiver();
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
