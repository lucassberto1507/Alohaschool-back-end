package br.com.gbrsistemas.estoque.rest;

import br.com.gbrsistemas.estoque.dao.CompraDAO;
import br.com.gbrsistemas.estoque.entidade.Compra;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class ServicesCompra {

    private static final String CHARSET_UTF8 = ";charset=utf-8";

    private CompraDAO compraDAO;

    @PostConstruct
    private void init() {
        compraDAO = new CompraDAO();
    }

    // Cria uma nova Compra
    @POST
    @Path("/newcomp")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public String addCompra(Compra compra) {
        String msg = "";

        System.out.println(compra.getIdCompra());

        try {
            int idGerado = compraDAO.addCompra(compra);

            msg = String.valueOf(idGerado);

        } catch (Exception e) {
            msg = "Erro ao inserir uma nova Compra!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    // Listar todas as Compras
    @GET
    @Path("/findcomp")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compra> listarCompras() {
        List<Compra> lista = null;
        try {
            lista = compraDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    // TODO: 30/09/2019 FAZER SERVICO ATUALIZAR COMPRAS
}
