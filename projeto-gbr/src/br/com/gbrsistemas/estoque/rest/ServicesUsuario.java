package br.com.gbrsistemas.estoque.rest;


import br.com.gbrsistemas.estoque.dao.UsuarioDAO;
import br.com.gbrsistemas.estoque.entidade.Usuario;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/service")
public class ServicesUsuario {

    private static final String CHARSET_UTF8 = ";charset=utf-8";

    private UsuarioDAO usuarioDAO;

    //LISTAR USUARIOS
    @PostConstruct
    private void init() {

        usuarioDAO = new UsuarioDAO();

    }

    @GET
    @Path("/finduser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsers() {
        List<Usuario> lista = null;
        try{
            lista = usuarioDAO.findAll();

        }catch ( Exception e ){
            e.printStackTrace();
        }
        return lista;
    }

    //LISTAR USUARIOS POR ID
    @GET
    @Path("/finduser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") int idUsuario) {
        Usuario u = null;
        try {
           u = usuarioDAO.findById(idUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    //CRIA NOVO USUARIO
    @POST
    @Path("/newuser")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    public String save (Usuario usuario) {
        String msg = "";

        try {
            int idGerado = usuarioDAO.save(usuario);

            msg = String.valueOf(idGerado);
        } catch (Exception e ) {
            msg = "Erro ao criar um novo Usuário!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    // EDITAR USUARIO PELO ID
    @PUT
    @Path("/updateuser/{id}")
    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(Usuario usuario, @PathParam("id") int idUser) {
        String msg = "";

        System.out.println(usuario.getNomeCompleto());

        try {
            usuarioDAO.update(usuario, idUser);

            msg = "Usuário editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar Usuário!" + e.getMessage();
        }
        return msg;
    }

    // DESATIVAR USUARIO PELO ID
    @PUT
    @Path("/deleteuser/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String removerUser(@PathParam("id") int idUser) {
        String msg = "";

        try {
            usuarioDAO.deleteUser(idUser);
            msg = String.valueOf(idUser) + "Usuário desativado com sucesso!";
        } catch (Exception e) {
            msg = "Não foi desativar/remover o Usuário!" + e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

}
