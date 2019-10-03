package br.com.gbrsistemas.estoque.dao;

import br.com.gbrsistemas.estoque.config.ConnectionFactory;
import br.com.gbrsistemas.estoque.entidade.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    //Lista todos os Usuários
    public List<Usuario> findAll() throws Exception {
        List<Usuario> lista = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT U.ID_USUARIO, U.USERNAME, U.PASSWORD, U.NOME_COMPLETO, U.TELEFONE, R.ID_ROLE, R.TIPO" +
                "FROM TB_USUARIO U JOIN TB_ROLE R ON U.TIPO_USUARIO = R.ID_ROLE ORDER BY U.NOME_COMPLETO";

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setUsername(rs.getString("USERNAME"));
            usuario.setPassword(rs.getString("PASSWORD"));
            usuario.setNomeCompleto(rs.getString("NOME_COMPLETO"));
            usuario.setTelefone(rs.getString("TELEFONE"));

            lista.add(usuario);
        }
        return lista;
    }


    //Lista por ID
    public Usuario findById(int idUsuario) throws Exception {

        Usuario usuario = new Usuario();
        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT U.ID_USUARIO, U.USERNAME, U.PASSWORD, U.NOME_COMPLETO, U.TELEFONE, R.ID_ROLE, R.TIPO" +
                "FROM TB_USUARIO U JOIN TB_ROLE R ON U.TIPO_USUARIO = R.ID_ROLE  WHERE U.ID_USUARIO = ? ORDER BY U.NOME_COMPLETO";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idUsuario);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setUsername(rs.getString("USERNAME"));
            usuario.setPassword(rs.getString("PASSWORD"));
            usuario.setNomeCompleto(rs.getString("NOME_COMPLETO"));
            usuario.setTelefone(rs.getString("TELEFONE"));

        }
        return usuario;
    }

    //Lista por nome
    public List<Usuario> findByNome(String nome) throws Exception {
        List<Usuario> lista = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT U.ID_USUARIO, U.USERNAME, U.PASSWORD, U.NOME_COMPLETO, U.TELEFONE, R.ID_ROLE, R.TIPO" +
                "FROM TB_USUARIO U JOIN TB_ROLE R ON U.TIPO_USUARIO = R.ID_ROLE  WHERE U.NOME_COMPLETO = '?%' ORDER BY U.NOME_COMPLETO";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, nome);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
            usuario.setUsername(rs.getString("USERNAME"));
            usuario.setPassword(rs.getString("PASSWORD"));
            usuario.setNomeCompleto(rs.getString("NOME_COMPLETO"));
            usuario.setTelefone(rs.getString("TELEFONE"));

            lista.add(usuario);
        }
        return lista;
    }

    //Cria um novo usuário
    public int save(Usuario usuario) throws Exception {

        int idGerado = 0;
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO TB_USUARIO SET USERNAME = ?, PASSWORD = ?, NOME_COMPLETO = ?, TELEFONE = ?, " +
                "TIPO_USUARIO = ?";


        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, usuario.getUsername());
        pstmt.setString(2, usuario.getPassword());
        pstmt.setString(3, usuario.getNomeCompleto());
        pstmt.setString(4, usuario.getTelefone());
        pstmt.setInt(5, usuario.getRole().getIdRole());

        pstmt.execute();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        return idGerado;
    }

    //Edita um usuário
    public void update(Usuario usuario, int idUsuario) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_USUARIO SET USERNAME = ?, PASSWORD = ?, NOME_COMPLETO = ?, TELEFONE = ?," +
                "TIPO_USUARIO = ? WHERE ID_USUARIO = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, usuario.getUsername());
        pstmt.setString(2, usuario.getPassword());
        pstmt.setString(3, usuario.getNomeCompleto());
        pstmt.setString(4, usuario.getTelefone());
        pstmt.setInt(5, usuario.getRole().getIdRole());
        pstmt.setInt(6, idUsuario);

        pstmt.executeUpdate();
    }

    //Desativar um usuário
    public void deleteUser(int idUsuario) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?;";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idUsuario);
        pstmt.execute();
    }

}
