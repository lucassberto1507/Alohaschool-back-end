package br.com.gbrsistemas.estoque.dao;


import br.com.gbrsistemas.estoque.config.ConnectionFactory;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// OK...
public class FornecedorDAO {

    //Cria um novo fornecedor - USANDO
    public int save(Fornecedor fornecedor) throws Exception {
        int idGerado = 0;
        Connection con = ConnectionFactory.getConnection();

        String sql = "INSERT INTO TB_FORNECEDOR SET NOME = ?, CNPJ = ?, TELEFONE = ?, CEP = ?, UF = ?, CIDADE = ?, " +
                "BAIRRO = ?, LOGRADOURO = ?, NUMERO = ?, STATUS = 'ATIVO'";

        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, fornecedor.getNome());
        pstmt.setString(2, fornecedor.getCnpj());
        pstmt.setString(3, fornecedor.getTelefone());
        pstmt.setString(4, fornecedor.getCep());
        pstmt.setString(5, fornecedor.getUf());
        pstmt.setString(6, fornecedor.getCidade());
        pstmt.setString(7, fornecedor.getBairro());
        pstmt.setString(8, fornecedor.getLogradouro());
        pstmt.setString(9, fornecedor.getNumero());

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }

        return idGerado;
    }

    //Edita um fornecedor - USANDO
    public void update(Fornecedor fornecedor, int idFornecedor) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        String sql = "UPDATE TB_FORNECEDOR SET NOME = ?, CNPJ = ?, TELEFONE = ?, CEP = ?, UF = ?, CIDADE = ?," +
                "BAIRRO = ?, LOGRADOURO = ?, NUMERO = ?, STATUS = ? WHERE ID_FORNECEDOR = ? ";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, fornecedor.getNome());
        pstmt.setString(2, fornecedor.getCnpj());
        pstmt.setString(3, fornecedor.getTelefone());
        pstmt.setString(4, fornecedor.getCep());
        pstmt.setString(5, fornecedor.getUf());
        pstmt.setString(6, fornecedor.getCidade());
        pstmt.setString(7, fornecedor.getBairro());
        pstmt.setString(8, fornecedor.getLogradouro());
        pstmt.setString(9, fornecedor.getNumero());
        pstmt.setInt(10, idFornecedor);

        pstmt.executeUpdate();

    }


    //Lista todos os fornecedores - USANDO
    public List<Fornecedor> findAll() throws Exception {
        List<Fornecedor> lista = new ArrayList<>();

        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR ORDER BY NOME";

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

            lista.add(forne);
        }
        return lista;
    }

    //Lista fornecedores ativos - USANDO
    public Fornecedor findById(int idFornecedor) throws Exception {
        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR WHERE ID_FORNECEDOR = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idFornecedor);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

        }
        return forne;
    }

    //Lista fornecedores ativos
    public List<Fornecedor> findByAtivo() throws Exception {
        List<Fornecedor> lista = new ArrayList<>();

        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR WHERE STATUS = 'ATIVO'";

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

            lista.add(forne);
        }
        return lista;
    }

    //Lista fornecedores desativados
    public List<Fornecedor> findByInativo() throws Exception {
        List<Fornecedor> lista = new ArrayList<>();

        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR WHERE STATUS = 'INATIVO'";

        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

            lista.add(forne);
        }
        return lista;
    }

    //Busca fornecedor pelo CNPJ
    public List<Fornecedor> findByCnpj(String cnpj) throws Exception {
        List<Fornecedor> lista = new ArrayList<>();

        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR WHERE CNPJ = ?%";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, cnpj);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

            lista.add(forne);
        }
        return lista;
    }

    //Busca fornecedor por nome
    public List<Fornecedor> findByNome(String fornecedor) throws Exception {
        List<Fornecedor> lista = new ArrayList<>();
        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR WHERE NOME = ?%";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, fornecedor);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

            lista.add(forne);
        }
        return lista;
    }

    //Desativa o fornecedor
    public void removeFornecedor(int idFornecedor) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_FORNECEDOR SET STATUS = 'INATIVO' WHERE ID_FORNECEDOR = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idFornecedor);
        pstmt.execute();
    }

    //Ativa o fornecedor
    public void activeFornecedor(int idFornecedor) throws Exception {
        Connection con = ConnectionFactory.getConnection();

        String sql = "UPDATE TB_FORNECEDOR SET STATUS = 'ATIVO' WHERE ID_FORNECEDOR = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, idFornecedor);
        pstmt.execute();
    }

    //Busca fornecedor por Status
    public List<Fornecedor> findByStatus(String status) throws Exception {
        List<Fornecedor> lista = new ArrayList<>();

        Fornecedor forne = null;

        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM TB_FORNECEDOR WHERE STATUS = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, status);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            forne = new Fornecedor();
            forne.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
            forne.setNome(rs.getString("NOME"));
            forne.setCnpj(rs.getString("CNPJ"));
            forne.setTelefone(rs.getString("TELEFONE"));
            forne.setCep(rs.getString("CEP"));
            forne.setUf(rs.getString("UF"));
            forne.setCidade(rs.getString("CIDADE"));
            forne.setBairro(rs.getString("BAIRRO"));
            forne.setLogradouro(rs.getString("LOGRADOURO"));
            forne.setNumero(rs.getString("NUMERO"));
            forne.setStatus(rs.getString("STATUS"));

            lista.add(forne);
        }
        return lista;
    }


}
