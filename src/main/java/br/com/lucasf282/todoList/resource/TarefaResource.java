package br.com.lucasf282.todoList.resource;

import br.com.lucasf282.todoList.Annotation.Split;
import br.com.lucasf282.todoList.entity.Tarefa;
import br.com.lucasf282.todoList.enums.DirecaoOrdemEnum;
import br.com.lucasf282.todoList.service.TarefaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/tarefas")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class TarefaResource {

    @Inject
    TarefaService service;

    @POST
    @Transactional
    public Response incluir(Tarefa tarefa) {
        service.incluir(tarefa);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Tarefa tarefa) {
        tarefa.setId(id);
        service.atualizar(tarefa);
        return Response.ok().build();
    }

    @GET
    public Response listar(
            @QueryParam("status") @Split(",") List<String> status,
            @QueryParam("order-by") String orderBy,
            @QueryParam("direction") DirecaoOrdemEnum direction,
            @QueryParam("page") int page,
            @QueryParam("size") int pageSize
    ) {
        List<Tarefa> tarefas = service.listar();
        return Response.ok().entity(tarefas).build();
    }

    @GET
    @Path("/{id}")
    public Response consultar(@PathParam("id") Long id) {
        Optional<Tarefa> tarefa = service.consultar(id);
        if(tarefa.isPresent()){
            return Response.ok().entity(tarefa).build();
        }else{
            return Response.noContent().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.ok().build();
    }
}
