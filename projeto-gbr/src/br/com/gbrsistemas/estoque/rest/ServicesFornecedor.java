package br.com.gbrsistemas.estoque.rest;

import br.com.gbrsistemas.estoque.dao.FornecedorDAO;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class ServicesFornecedor {

    private static final String CHARSET_UTF8 = ";charset=utf-8";

    private FornecedorDAO fornecedorDAO;

    @PostConstruct
    private void init(){

        fornecedorDAO = new FornecedorDAO();
    }

    //BUSCAR FORNECEDOR POR ID ok
    @GET
    @Path("/findforn/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fornecedor findById(@PathParam("id") int idFornecedor) {
        Fornecedor f = null;
        try {
            f = fornecedorDAO.findById(idFornecedor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    //LISTA TODOS OS FORNECEDORES ok
    @GET
    @Path("/findforn")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fornecedor> findAll() {
        List<Fornecedor> lista = null;
        try {
            lista = fornecedorDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Cria um novo Fornecedor ok
    @POST
    @Path("/newforn")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public String save(Fornecedor fornecedor) {
        String msg = "";
        System.out.println(fornecedor.getNome());

        try {
            int idGerado = fornecedorDAO.save(fornecedor);

            msg = String.valueOf(idGerado);

        } catch (Exception e) {
            msg = "Erro ao criar um novo Fornecedor!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    // Editar um Fornecedor Pelo ID
    @PUT
    @Path("/updateforn/{id}")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(Fornecedor fornecedor, @PathParam("id") int idFornecedor) {
        String msg = "";

        System.out.println(fornecedor.getNome());

        try {
            fornecedorDAO.update(fornecedor, idFornecedor);

            msg = "Fornecedor editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar fornecedor!" + e.getMessage();
        }
        return msg;
    }

    //Desativar um Fornecedor pelo ID
    @PUT
    @Path("/removeforn/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String removeFornecedor(@PathParam("id") int idFornecedor) {
        String msg = "";

        try {
            fornecedorDAO.removeFornecedor(idFornecedor);
            msg = String.valueOf(idFornecedor) + "Fornecedor desativado com sucesso!";
        } catch (Exception e) {
            msg = "Não foi possivel desativar remover o fornecedor!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    //Ativa um Fornecedor pelo ID
    @PUT
    @Path("/activeforn/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String activeFornecedor(@PathParam("id") int idFornecedor) {
        String msg = "";

        try {
            fornecedorDAO.activeFornecedor(idFornecedor);
            msg = String.valueOf(idFornecedor) + "Fornecedor ativado com sucesso!";
        } catch (Exception e) {
            msg = "Não foi possivel ativar remover o fornecedor!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }
}
