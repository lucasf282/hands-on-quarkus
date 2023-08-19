package br.com.lucasf282.todoList.service;

import br.com.lucasf282.todoList.entity.Projeto;
import br.com.lucasf282.todoList.repository.ProjetoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ProjetoService {

    @Inject
    ProjetoRepository repository;

    public void incluir(Projeto projeto) {
        repository.persist(projeto);
    }

    public Optional<Projeto> consultar(Long id) {
        return repository.findByIdOptional(id);
    }

    public List<Projeto> listar() {
        return repository.listAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Projeto projeto) {
        repository.persist(projeto);
    }
}
