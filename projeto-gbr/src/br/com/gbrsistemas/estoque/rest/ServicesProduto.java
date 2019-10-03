package br.com.gbrsistemas.estoque.rest;

import br.com.gbrsistemas.estoque.dao.ProdutoDAO;
import br.com.gbrsistemas.estoque.entidade.Produto;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class ServicesProduto {

    private static final String CHARSET_UTF8 = ";charset=utf-8";

    private ProdutoDAO produtoDAO;

    @PostConstruct
    private void init() {
        produtoDAO = new ProdutoDAO();
    }

    // Cria um novo produto
    @POST
    @Path("/newprod")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public String save(Produto produto) {
        String msg = "";

        System.out.println(produto.getNome());

        try {
            int idGerado = produtoDAO.save(produto);

            msg = String.valueOf(idGerado);

        } catch (Exception e) {
            msg = "Erro ao criar um novo Produto: " + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    // Editar um Produto por id
    @PUT
    @Path("/updateprod/{id}")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(Produto produto, @PathParam("id") int idProduto) {
        String msg = "";

        System.out.println(produto.getNome());

        try {
            produtoDAO.update(produto, idProduto);

            msg = "Produto editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar produto!" + e.getMessage();
        }
        return msg;
    }

    // Listar todos os Produtos
    @GET
    @Path("/findprod")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarProdutos() {
        List<Produto> lista = null;
        try {
            lista = produtoDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    //Buscar produtos por ID
    @GET
    @Path("/findprod/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto findById(@PathParam("id") int idProduto) {
        Produto p = null;
        try {
            p = produtoDAO.findById(idProduto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
