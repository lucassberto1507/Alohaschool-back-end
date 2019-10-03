package br.com.gbrsistemas.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.gbrsistemas.estoque.config.ConnectionFactory;
import br.com.gbrsistemas.estoque.entidade.Prato;


public class PratoDAO {

	public List<Prato> findAll() throws Exception {
		List<Prato> lista = new ArrayList<>();

		Connection con = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM TB_PRATO";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Prato prato = new Prato();
			prato.setIdPrato(rs.getInt("ID_PRATO"));
			prato.setNome(rs.getString("NOME"));
			prato.setDescricao(rs.getString("DESCRICAO"));
			prato.setPreco(rs.getDouble("PRECO"));

			lista.add(prato);

		}
		return lista;
	}

	public Prato findById(int idPrato) throws Exception {
		Prato prato = null;

		Connection con = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM TB_PRATO WHERE ID_PRATO = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, idPrato);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			prato = new Prato();
			prato.setIdPrato(rs.getInt("ID_PRATO"));
			prato.setNome(rs.getString("NOME"));
			prato.setDescricao(rs.getString("DESCRICAO"));
			prato.setPreco(rs.getDouble("PRECO"));

		}
		return prato;
	}

	public Prato findByNome(String nome) throws Exception {
		Prato prato = null;

		Connection con = ConnectionFactory.getConnection();

		String sql = "SELECT * FROM TB_PRATO WHERE NOME = ?%";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, nome);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			prato = new Prato();
			prato.setIdPrato(rs.getInt("ID_PRATO"));
			prato.setNome(rs.getString("NOME"));
			prato.setDescricao(rs.getString("DESCRICAO"));
			prato.setPreco(rs.getDouble("PRECO"));

		}
		return prato;
	}

	public int save(Prato prato) throws Exception {
		int idGerado = 0;
		Connection con = ConnectionFactory.getConnection();

		String sql = "INSERT INTO TB_PRATO SET NOME = ?, DESCRICAO = ?, PRECO = ?";

		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, prato.getNome());
		pstmt.setString(2, prato.getDescricao());
		pstmt.setDouble(3, prato.getPreco());

		pstmt.executeUpdate();

		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}
		return idGerado;
	}

	public void update(Prato prato, int idPrato) throws Exception {
		Connection con = ConnectionFactory.getConnection();

		String sql = "UPDATE TB_PRATO SET NOME = ?, DESCRICAO = ?, PRECO = ?" +
				"WHERE ID_PRATO = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, prato.getNome());
		pstmt.setString(2, prato.getDescricao());
		pstmt.setDouble(3, prato.getPreco());
		pstmt.setInt(4, idPrato);

		pstmt.execute();

	}
	
}
