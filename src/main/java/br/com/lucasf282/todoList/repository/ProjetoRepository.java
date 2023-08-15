package br.com.lucasf282.todoList.repository;

import br.com.lucasf282.todoList.entity.Projeto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProjetoRepository implements PanacheRepository<Projeto> {
}
