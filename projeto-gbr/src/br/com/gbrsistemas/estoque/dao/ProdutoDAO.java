package br.com.gbrsistemas.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.gbrsistemas.estoque.config.ConnectionFactory;
import br.com.gbrsistemas.estoque.entidade.Categoria;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;
import br.com.gbrsistemas.estoque.entidade.Medida;
import br.com.gbrsistemas.estoque.entidade.Produto;

public class ProdutoDAO {

    //Adiciona um novo produto
    public int save(Produto produto) throws Exception {
        int idGerado = 0;
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO TB_PRODUTO SET NOME = ?, PRECO = ?, MARCA = ?, QUANTIDADE = ?, FABRICACAO = ?, " +
                "VALIDADE = ? CATEGORIA_ID = ?, MEDIDA_ID = ?, FORNECEDOR_ID = ?";

        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, produto.getNome());
        pstmt.setDouble(2, produto.getPreco());
        pstmt.setString(3, produto.getMarca());
        pstmt.setInt(4, produto.getQuantidade());
        pstmt.setDate(5, produto.getFabricacao());
        pstmt.setDate(6, produto.getValidade());
        pstmt.setInt(7, produto.getCategoria().getIdCategoria());
        pstmt.setInt(8, produto.getMedida().getIdMedida());
        pstmt.setInt(9, produto.getFornecedor().getIdFornecedor());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        return idGerado;
    }

    //Edita um produto
    public void update(Produto produto, int idProduto) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_PRODUTO SET NOME = ?, PRECO = ?, MARCA = ?, QUANTIDADE = ?, FABRICACAO = ?, " +
                "VALIDADE = ?, CATEGORIA = ?, MEDIDA = ?, FORNECEDOR = ? WHERE ID_PRODUTO = ?;";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, produto.getNome());
        pstmt.setDouble(2, produto.getPreco());
        pstmt.setString(3, produto.getMarca());
        pstmt.setInt(4, produto.getQuantidade());
        pstmt.setDate(5, produto.getFabricacao());
        pstmt.setDate(6, produto.getValidade());
        pstmt.setInt(7, produto.getCategoria().getIdCategoria());
        pstmt.setInt(8, produto.getMedida().getIdMedida());
        pstmt.setInt(9, produto.getFornecedor().getIdFornecedor());
        pstmt.setInt(10, idProduto);

        pstmt.executeUpdate();
    }


    //Lista todos os produtos
    public List<Produto> findAll() throws Exception {
        List<Produto> lista = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT P.ID_PRODUTO, P.NOME, P.MARCA, P.QUANTIDADE, P.PRECO, M.ID_MEDIDA, M.TIPO, C.ID_CATEGORIA, C.TIPO, P.FABRICACAO, P.VALIDADE, F.ID_FORNECEDOR, F.NOME, F.TELEFONE " +
                "FROM TB_PRODUTO P " +
                "JOIN TB_FORNECEDOR F " +
                "JOIN TB_CATEGORIA C " +
                "JOIN TB_MEDIDA M " +
                "ON P.CATEGORIA = C.ID_CATEGORIA " +
                "AND P.MEDIDA = M.ID_MEDIDA " +
                "AND P.FORNECEDOR = F.ID_FORNECEDOR " +
                "ORDER BY P.NOME";

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            //PRODUTO part 1
            Produto prod = new Produto();
            prod.setIdProduto(rs.getInt("ID_PRODUTO"));
            prod.setNome(rs.getString("NOME"));
            prod.setMarca(rs.getString("MARCA"));
            prod.setQuantidade(rs.getInt("QUANTIDADE"));
            prod.setPreco(rs.getDouble("PRECO"));

            //MEDIDA
            Medida medida = new Medida();
            medida.setIdMedida(rs.getInt("M.ID_MEDIDA"));
            medida.setTipo(rs.getString("M.TIPO"));
            //CATEGORIA
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("C.ID_CATEGORIA"));
            categoria.setTipo(rs.getString("C.TIPO"));

            //PRODUTO part 2
            prod.setFabricacao(rs.getDate("FABRICACAO"));
            prod.setValidade(rs.getDate("VALIDADE"));

            //FORNECEDOR
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(rs.getInt("F.ID_FORNECEDOR"));
            fornecedor.setNome(rs.getString("F.NOME"));
            fornecedor.setTelefone(rs.getString("F.TELEFONE"));

            prod.setMedida(medida);
            prod.setCategoria(categoria);
            prod.setFornecedor(fornecedor);

            lista.add(prod);

        }
        return lista;
    }

    //Busca produto por ID
    public Produto findById(int idProduto) throws Exception {
        List<Produto> lista = new ArrayList<>();
        Produto prod = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_PRODUTO P " +
                "JOIN TB_FORNECEDOR F " +
                "JOIN TB_CATEGORIA C " +
                "JOIN TB_MEDIDA M  " +
                "ON P.CATEGORIA = C.ID_CATEGORIA " +
                "AND P.MEDIDA = M.ID_MEDIDA " +
                "AND P.FORNECEDOR = F.ID_FORNECEDOR " +
                "WHERE P.ID_PRODUTO = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idProduto);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            //PRODUTO part 1
            prod = new Produto();
            prod.setIdProduto(rs.getInt("ID_PRODUTO"));
            prod.setNome(rs.getString("NOME"));
            prod.setMarca(rs.getString("MARCA"));
            prod.setQuantidade(rs.getInt("QUANTIDADE"));
            prod.setPreco(rs.getDouble("PRECO"));

            //MEDIDA
            Medida medida = new Medida();
            medida.setIdMedida(rs.getInt("M.ID_MEDIDA"));
            medida.setTipo(rs.getString("M.TIPO"));
            //CATEGORIA
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("C.ID_CATEGORIA"));
            categoria.setTipo(rs.getString("C.TIPO"));

            //PRODUTO part 2
            prod.setFabricacao(rs.getDate("FABRICACAO"));
            prod.setValidade(rs.getDate("VALIDADE"));

            //FORNECEDOR
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(rs.getInt("F.ID_FORNECEDOR"));
            fornecedor.setNome(rs.getString("F.NOME"));
            fornecedor.setTelefone(rs.getString("F.TELEFONE"));

            prod.setMedida(medida);
            prod.setCategoria(categoria);
            prod.setFornecedor(fornecedor);

        }
        return prod;
    }

    //Busca um produto pelo nome do item
    public Produto findByNome(String nome) throws Exception {
        Produto prod = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_PRODUTOS WHERE ITEM LIKE = '?%'";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, nome);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            prod = new Produto();
            prod.setIdProduto(rs.getInt("ID_PRODUTO"));
            prod.setNome(rs.getString("NOME"));
            prod.setMarca(rs.getString("MARCA"));
            prod.setQuantidade(rs.getInt("QUANTIDADE"));
            prod.setPreco(rs.getDouble("PRECO"));
            prod.setFabricacao(rs.getDate("FABRICACAO"));
            prod.setValidade(rs.getDate("VALIDADE"));
        }
        return prod;
    }




    //Altera o status de um produto para INATIVO.
    public void desativarProduto(int idProduto) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_PRODUTO SET STATUS = 'INATIVO' WHERE ID_PRODUTO = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idProduto);
        pstmt.execute();
    }

    //Baixa a quantidade em estoque de um produto.
    public void subtrairProduto(int idProduto, int qtde) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_PRODUTO SET QUANTIDADE = QUANTIDADE - ? WHERE ID_PRODUTO = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, qtde);
        pstmt.setInt(2, idProduto);
        pstmt.executeUpdate();

    }

    public void somarProduto(int idProduto, int qdte) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_PRODUTO SET QUANTIDADE = QUANTIDADE + ? WHERE ID_PRODUTO = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, qdte);
        pstmt.setInt(2, idProduto);
        pstmt.executeUpdate();
    }
}
