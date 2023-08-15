package br.com.lucasf282.todoList.resource;

import br.com.lucasf282.todoList.entity.Projeto;
import br.com.lucasf282.todoList.service.ProjetoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/projetos")
@Produces(MediaType.APPLICATION_JSON)
public class ProjetoResource {

    ProjetoService service = new ProjetoService();

    @POST
    public Response incluir(Projeto projeto){
        service.incluir(projeto);
        return Response.ok().build();
    }

    @PUT
    public Response atualizar(Projeto projeto){
        service.atualizar(projeto);
        return Response.ok().build();
    }

    @GET
    public Response listar(Projeto projeto) {
        List<Projeto> projetoResponse = service.listar();
        return Response.ok().entity(projetoResponse).build();
    }

    @GET
    @Path("/{id}")
    public Response consultar(@PathParam("id") Long id) {
        Projeto projeto = service.consultar(id).orElse(new Projeto());
        return Response.ok().entity(projeto).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.deletar(id);
        return Response.ok().build();
    }
}
