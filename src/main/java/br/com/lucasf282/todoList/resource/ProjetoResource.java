package br.com.lucasf282.todoList.resource;

import br.com.lucasf282.todoList.Annotation.Split;
import br.com.lucasf282.todoList.entity.Projeto;
import br.com.lucasf282.todoList.entity.Tarefa;
import br.com.lucasf282.todoList.enums.DirecaoOrdemEnum;
import br.com.lucasf282.todoList.service.ProjetoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/projetos")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ProjetoResource {

    @Inject
    ProjetoService service;

    @POST
    @Transactional
    public Response incluir(Projeto projeto) {
        service.incluir(projeto);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response atualizar(@PathParam("id") Long id, Projeto projeto) {
        projeto.setId(id);
        service.atualizar(projeto);
        return Response.ok().build();
    }

    @GET
    public Response listar(
            @QueryParam("teste-split") @Split(".") List<String> testeSplit,
            @QueryParam("order-by") String orderBy,
            @QueryParam("direction") DirecaoOrdemEnum direction,
            @QueryParam("page") int page,
            @QueryParam("size") int pageSize
    ) {
        List<Projeto> projetos = service.listar(orderBy, direction, page, pageSize);
        return Response.ok().entity(projetos).build();
    }

    @GET
    @Path("/{id}")
    public Response consultar(@PathParam("id") Long id) {
        Optional<Projeto> projeto = service.consultar(id);
        if(projeto.isPresent()){
            return Response.ok().entity(projeto).build();
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

    @GET
    @Path("/{id}/tarefas")
    public Response listar(@PathParam("id") Long id) {
        List<Tarefa> tarefas = service.listarPorProjeto(id);
        return Response.ok().entity(tarefas).build();
    }
}
