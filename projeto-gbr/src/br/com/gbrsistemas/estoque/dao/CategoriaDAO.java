package br.com.gbrsistemas.estoque.dao;

import br.com.gbrsistemas.estoque.config.ConnectionFactory;
import br.com.gbrsistemas.estoque.entidade.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// OK
public class CategoriaDAO {

    //Cria uma nova categoria
    public int save(Categoria categoria) throws Exception {
        int idGerado = 0;
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO TB_CATEGORIA SET TIPO = ?";

        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, categoria.getTipo());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }

        return idGerado;
    }

    //Lista todas as categorias
    public List<Categoria> findAll() throws Exception {

        List<Categoria> lista = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_CATEGORIA";

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setIdCategoria(rs.getInt("ID_CATEGORIA"));
            cat.setTipo(rs.getString("TIPO"));

            lista.add(cat);
        }
        return lista;
    }


}