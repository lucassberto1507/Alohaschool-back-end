package br.com.gbrsistemas.estoque.rest;

import br.com.gbrsistemas.estoque.dao.PratoDAO;
import br.com.gbrsistemas.estoque.entidade.Prato;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class ServicesPrato {

    private static final String CHARSET_UTF8 = ";charset=utf-8";

    private PratoDAO pratoDAO;

    @PostConstruct
    private void init() {
        pratoDAO = new PratoDAO();
    }

    // Cria um novo prato
    @POST
    @Path("/newpra")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public String save(Prato prato) {
        String msg = "";

        System.out.println(prato.getIdPrato());

        try {
            int idGerado = pratoDAO.save(prato);

            msg = String.valueOf(idGerado);

        } catch (Exception e) {
            msg = "Erro ao criar uma novo Pedido!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    // Editar um prato Pelo ID
    @PUT
    @Path("/updatepra/{id}")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(Prato prato, @PathParam("id") int idPrato) {
        String msg = "";

        try {
            pratoDAO.update(prato, idPrato);

            msg = "Prato editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar Prato!" + e.getMessage();
        }
        return msg;
    }


    // Listar todos os prato
    @GET
    @Path("/findpra")
    public List<Prato> listarPedidos() {
        List<Prato> lista = null;
        try {
            lista = pratoDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


    //BUSCAR PRATO POR ID
    @GET
    @Path("/findpra/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prato findById(@PathParam("id") int idPrato) {
        Prato p = null;
        try {
            p = pratoDAO.findById(idPrato);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }


}
